package com.bookmanagement.book.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookmanagement.book.model.Publisher;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Integer> {

}
