package com.bookmanagement.book.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bookmanagement.book.model.Book;

public class BookRowMapper implements RowMapper<Book> {

	public Book mapRow(ResultSet resultSet, int i) throws SQLException {

		Book book = new Book();
		book.setBookCode(resultSet.getString("book_code"));
		book.setBookName(resultSet.getString("book_name"));
		book.setBookCategory(resultSet.getString("book_category"));
		book.setAuthorName(resultSet.getString("author_name"));
		book.setPublisherName(resultSet.getString("publisher_name"));
		return book;
	}
}
