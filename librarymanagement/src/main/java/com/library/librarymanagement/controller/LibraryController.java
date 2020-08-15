package com.library.librarymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.librarymanagement.model.Library;
import com.library.librarymanagement.repository.LibraryRepository;

@RestController
public class LibraryController {

	@Autowired
	private LibraryRepository libraryRepository;

	@GetMapping("/library")
	public String library(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		Library l = new Library();
		l.setBookId("Steny");
		l.setName("Steny");
		model.addAttribute("name", name);
		libraryRepository.save(l);
		return "library";
	}

}