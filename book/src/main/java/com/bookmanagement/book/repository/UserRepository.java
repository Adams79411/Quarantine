package com.bookmanagement.book.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookmanagement.book.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}