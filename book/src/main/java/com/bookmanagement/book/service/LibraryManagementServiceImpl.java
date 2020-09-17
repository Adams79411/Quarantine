package com.bookmanagement.book.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.bookmanagement.book.model.Attachments;
import com.bookmanagement.book.model.Author;
import com.bookmanagement.book.model.Book;
import com.bookmanagement.book.model.Publisher;
import com.bookmanagement.book.model.User;
import com.bookmanagement.book.repository.AttachmentRepository;
import com.bookmanagement.book.repository.AuthorRepository;
import com.bookmanagement.book.repository.BookRepository;
import com.bookmanagement.book.repository.PublisherRepository;
import com.bookmanagement.book.repository.UserRepository;
import com.sun.el.parser.ParseException;

/**
 * LibraryManagementServiceImpl class is used to provide the library management
 * details such as book ,user and publisher details.
 * 
 * @author Steny Adams J
 *
 */
@Service
public class LibraryManagementServiceImpl implements LibraryManagementService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private PublisherRepository publisherRepository;

	@Autowired
	private AttachmentRepository attachmentRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<User> getUser() {
		List<User> userList = new ArrayList<>();
		userRepository.findAll().forEach(predicate -> {
			User data = new User();
			data.setUserId(predicate.getUserId());
			data.setUserName(predicate.getUserName());
			data.setAdmin(predicate.isAdmin());
			userList.add(data);
		});
		return userList;
	}

	@Override
	public boolean deleteData(String userId) {
		Optional<User> userData = userRepository.findById(Integer.parseInt(userId));
		if (userData.isPresent()) {
			userRepository.deleteById(Integer.parseInt(userId));
			return true;
		}
		return false;
	}

	@Override
	public User getSpecifUserData(String userId) {
		Optional<User> user = userRepository.findById(Integer.parseInt(userId));
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}

	@Override
	public boolean updateData(User user) {
		Optional<User> userData = userRepository.findById(user.getUserId());
		if (userData.isPresent()) {
			userRepository.save(user);
			return true;
		}
		return false;
	}

	@Override
	public Integer saveBookDetails(Book book) {
		String query = "select * from book where book_code=?";
		List<Map<String, Object>> dataList = jdbcTemplate.queryForList(query, new Object[] { book.getBookCode() });
		if (CollectionUtils.isEmpty(dataList)) {
			Book bookDetail = bookRepository.save(book);
			if (book.getAuthorName().length() != 0) {
				Author author = new Author();
				author.setAuthorName(book.getAuthorName());
				author.setBookName(bookDetail.getBookName());
				author.setBookId(bookDetail.getBookId());
				Author authorDetail = authorRepository.save(author);
				bookDetail.setAuthorId(String.valueOf(authorDetail.getAuthorId()));
			}
			if (book.getPublisherName().length() != 0) {
				Publisher publisher = new Publisher();
				publisher.setPublisherName(book.getPublisherName());
				publisher.setBookName(bookDetail.getBookName());
				publisher.setBookId(bookDetail.getBookId());
				Publisher publisherDetail = publisherRepository.save(publisher);
				bookDetail.setPublisherId(String.valueOf(publisherDetail.getPublisherId()));
			}
			bookRepository.save(bookDetail);
			return bookDetail.getBookId();
		}
		return 0;
	}

	@Override
	public List<Book> getBookDetails() {
		List<Book> bookList = new ArrayList<>();
		bookRepository.findAll().forEach(predicate -> {
			Book data = new Book();
			data.setBookId(predicate.getBookId());
			data.setBookCode(predicate.getBookCode());
			data.setBookName(predicate.getBookName());
			data.setAuthorId(predicate.getAuthorId());
			data.setAuthorName(predicate.getAuthorName());
			data.setUserId(predicate.getUserId());
			data.setUserName(predicate.getUserName());
			data.setPublisherId(predicate.getPublisherId());
			data.setPublisherName(predicate.getPublisherName());
			data.setBookCategory(predicate.getBookCategory());
			data.setBookIssueLastDate(predicate.getBookIssueLastDate());
			data.setBookLendDate(predicate.getBookLendDate());
			bookList.add(data);
		});
		return bookList;
	}

	@Override
	public boolean deleteBookData(String bookId) {
		Optional<Book> bookData = bookRepository.findById(Integer.parseInt(bookId));
		if (bookData.isPresent()) {
			bookRepository.deleteById(Integer.parseInt(bookId));
			return true;
		}
		return false;
	}

	@Override
	public boolean saveUser(User user) {
		userRepository.save(user);
		return true;
	}

	@Override
	public boolean storeFile(MultipartFile file, int userId) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			Attachments dbFile = new Attachments();
			dbFile.setData(file.getBytes());
			dbFile.setFileName(fileName);
			dbFile.setFileType(file.getContentType());
			attachmentRepository.save(dbFile);
			return true;
		} catch (IOException ex) {
			return false;
		}
	}

	@Override
	public List<Book> getSearchDetails(String search, Integer criteria) {
		String fieldName = null;
		if (criteria == 0) {
			fieldName = "author_name";
		} else if (criteria == 1) {
			fieldName = "publisher_name";
		} else if (criteria == 2) {
			fieldName = "book_name";
		} else {
			fieldName = "book_category";
		}
		String query = "select * from book where " + fieldName + " like ?";
		List<Book> bookList = new ArrayList<>();
		List<Map<String, Object>> dataList = jdbcTemplate.queryForList(query, new Object[] { "%" + search + "%" });
		for (Map row : dataList) {
			Book book = new Book();
			book.setBookCode(row.get("book_code").toString());
			book.setBookName(row.get("book_name").toString());
			book.setBookCategory(row.get("book_category").toString());
			book.setAuthorName(row.get("author_name").toString());
			book.setPublisherName(row.get("publisher_name").toString());
			bookList.add(book);
		}
		return bookList;
	}

	@Override
	public boolean takeBook(Integer bookId) throws java.text.ParseException {
		Optional<Book> book = bookRepository.findById(bookId);
		if (book.isPresent() && book.get().getUserId() == 0) {
			Book bookDetail = book.get();
			bookDetail.setUserId(2);
			bookDetail.setUserName("Admin");
			Date date = new Date();
			String modifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			bookDetail.setBookLendDate(modifiedDate);
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(modifiedDate));
			c.add(Calendar.DAY_OF_MONTH, 5);
			String newDate = sdf.format(c.getTime());
			bookDetail.setBookIssueLastDate(newDate);
			bookRepository.save(bookDetail);
			return false;
		}
		return true;
	}
}