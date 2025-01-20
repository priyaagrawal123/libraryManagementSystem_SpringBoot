package com.example.demo.service.impl;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    // Override the getAllAuthors method
    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthorById(String id) {
        authorRepository.deleteById(id);
    }
    @Override
    public Author updateAuthor(String id, Author updatedAuthor) {
        try {
            // Fetch the existing author
            Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with ID: " + id));
    
            // Update fields only if they are not null
            if (updatedAuthor.getName() != null) {
                existingAuthor.setName(updatedAuthor.getName());
            }
            if (updatedAuthor.getBio() != null) {
                existingAuthor.setBio(updatedAuthor.getBio());
            }
    
            // Save updated author
            return authorRepository.save(existingAuthor);
        } catch (Exception e) {
            System.err.println("Error during author update: " + e.getMessage());
            throw new RuntimeException("Failed to update author with ID: " + id, e);
        }
    }
    
}
