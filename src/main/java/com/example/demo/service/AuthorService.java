package com.example.demo.service;

import com.example.demo.model.Author;
import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();      // Method to get all authors
    Author saveAuthor(Author author);  // Method to save a new author
    void deleteAuthorById(String id);    // Method to delete an author by ID
    Author updateAuthor(String id, Author author);  // Method to update an existing author
}
Your enterprises
