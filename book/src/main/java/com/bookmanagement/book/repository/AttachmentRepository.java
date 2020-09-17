package com.bookmanagement.book.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookmanagement.book.model.Attachments;

@Repository
public interface AttachmentRepository extends CrudRepository<Attachments, Integer> {

}
