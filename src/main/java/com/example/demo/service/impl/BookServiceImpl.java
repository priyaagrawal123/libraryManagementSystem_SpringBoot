package com.example.demo.service.impl;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
    @Override
    public Book updateBook(String id, Book updatedBook) {
        try {
            // Fetch the existing book from the database
            Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));
    
            // Update fields only if they are not null
            if (updatedBook.getAuthorName() != null) {
                existingBook.setAuthorName(updatedBook.getAuthorName());
            }
            if (updatedBook.getTitle() != null) {
                existingBook.setTitle(updatedBook.getTitle());
            }
            if (updatedBook.getGenre() != null) {
                existingBook.setGenre(updatedBook.getGenre());
            }
            if (updatedBook.getPublishedYear() != null) {
                existingBook.setPublishedYear(updatedBook.getPublishedYear());
            }
    
            // Save the updated book back to the repository
            return bookRepository.save(existingBook);
        } catch (RuntimeException e) {
            System.err.println("Runtime Error during book update: " + e.getMessage());
            throw new RuntimeException("Failed to update book with ID: " + id, e);
        } catch (Exception e) {
            System.err.println("Unexpected Error during book update: " + e.getMessage());
            throw new RuntimeException("An unexpected error occurred while updating book with ID: " + id, e);
        }
    }
    
    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }
    
    public List<Book> getBooksByAuthorName(String authorName) {
        return bookRepository.findByAuthorNameContainingIgnoreCase(authorName);
    }

    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }
}
   
