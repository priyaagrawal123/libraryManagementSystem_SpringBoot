package com.example.demo.repository;

import com.example.demo.model.Book;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, ObjectId> {
 List<Book> findByAuthorNameContainingIgnoreCase(String authorName);
    List<Book> findByTitleContainingIgnoreCase(String title);
}
