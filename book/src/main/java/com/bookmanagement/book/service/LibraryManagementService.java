package com.bookmanagement.book.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bookmanagement.book.model.Book;
import com.bookmanagement.book.model.User;

/**
 * LibraryManagementService interface is used to provide the necessary methods
 * needed to fetch the user details.
 * 
 * @author Steny Adams J
 *
 */
@Service
public interface LibraryManagementService {

	public List<User> getUser();

	public List<Book> getBookDetails();

	public List<Book> getSearchDetails(String search, Integer criteria);

	public boolean deleteData(String userId);

	public User getSpecifUserData(String userId);

	public boolean updateData(User user);

	public Integer saveBookDetails(Book book);

	public boolean deleteBookData(String bookId);

	public boolean saveUser(User user);

	public boolean storeFile(MultipartFile file, int userId);
}
