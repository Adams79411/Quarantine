package com.bookmanagement.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bookmanagement.book.model.Book;
import com.bookmanagement.book.model.User;
import com.bookmanagement.book.service.LibraryManagementService;

@RestController
public class LibraryManagementController {

	@Autowired
	LibraryManagementService libraryManagementService;

	@GetMapping("/")
	public String getHeath() {
		return "OK";
	}

	@GetMapping("/users/")
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4200")
	public List<User> getUsers() {
		return libraryManagementService.getUser();
	}

	@GetMapping("/books/")
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Book> getBooks() {
		return libraryManagementService.getBookDetails();
	}

	@DeleteMapping("/deleteData/{userId}")
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4200")
	public boolean deleteData(@PathVariable String userId) {
		return libraryManagementService.deleteData(userId);
	}

	@DeleteMapping("/deleteBookData/{bookId}")
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4200")
	public boolean deleteBookData(@PathVariable String bookId) {
		return libraryManagementService.deleteBookData(bookId);
	}

	@GetMapping("/getSpecificUserData/{userId}")
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4200")
	public User getSpecificUserData(@PathVariable String userId) {
		return libraryManagementService.getSpecifUserData(userId);
	}

	@PostMapping("/updateUser/")
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4200")
	public boolean updateUser(@RequestBody User user) {
		return libraryManagementService.updateData(user);
	}

	@PostMapping("/saveUser/")
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4200")
	public boolean saveUser(@RequestBody User user) {
		return libraryManagementService.saveUser(user);
	}

	@PostMapping("/saveBookDetails/")
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4200")
	public Integer saveBookDetails(@RequestBody Book book) {
		return libraryManagementService.saveBookDetails(book);
	}

	@PostMapping("/fileUpload/{bookId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public boolean handleFileUpload(@PathVariable int bookId, @RequestParam("file") MultipartFile file) {
		return libraryManagementService.storeFile(file, bookId);
	}

	@GetMapping("/search/{criteria}/{search}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Book> search(@PathVariable Integer criteria, @PathVariable String search) {
		List<Book> dataList = libraryManagementService.getSearchDetails(search, criteria);
		return dataList;
	}
}
