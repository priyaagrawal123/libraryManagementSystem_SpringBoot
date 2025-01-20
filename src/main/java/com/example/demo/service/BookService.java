package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();
    Optional<Book> getBookById(String id);
    Book createBook(Book book);
    Book updateBook(String id, Book updatedBook);
    void deleteBook(String id);
    List<Book> getBooksByAuthorName(String authorName);
    List<Book> getBooksByTitle(String title);
}
