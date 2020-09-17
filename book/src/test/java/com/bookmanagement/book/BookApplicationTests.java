package com.bookmanagement.book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.bookmanagement.book.controller.LibraryManagementController;
import com.bookmanagement.book.model.Book;
import com.bookmanagement.book.model.User;
import com.bookmanagement.book.repository.BookRepository;
import com.bookmanagement.book.repository.UserRepository;
import com.bookmanagement.book.service.LibraryManagementService;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = { LibraryManagementController.class, LibraryManagementService.class })
@WebMvcTest
class BookApplicationTests {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private MockMvc mockMvc;

	@Test
	void registrationWorksThroughAllLayers() throws Exception {
		User user = new User();
		user.setUserName("AdminTest");
		user.setAdmin(true);
		User data = userRepository.save(user);
		assertNotEquals(data.getUserId(), 0);
	}

	@Test
	void getText() throws Exception {
		Book book = new Book();
		book.setBookName("StenyCheck");
		Book data = bookRepository.save(book);
		assertNotEquals(data.getBookId(), 0);
	}

	@Test
	public void checkConnectionAPI() throws Exception {
		search(0, "Steny");
	}

	private void search(int i, String string) throws Exception {
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/search/{" + i + "}/{" + string + "}")
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String test = result.getResponse().getContentAsString();
		assertNotNull(test);
	}
}
