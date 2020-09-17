package com.bookmanagement.book.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookmanagement.book.model.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {

}
