package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    // Constructor injection for the service
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors(); // Calls the service layer to get authors
    }
     @PostMapping
    public Author addAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }
    @PutMapping("/{id}")
public Author updateAuthor(@PathVariable String id, @RequestBody Author author) {
    System.out.println("Updating author with ID: " + id);
    System.out.println("New Author Details: " + author);
    
    try {
        return authorService.updateAuthor(id, author);
    } catch (RuntimeException e) {
        System.err.println("Error: " + e.getMessage());
        throw e;
    }
}

    @DeleteMapping("/{id}")
public void deleteAuthor(@PathVariable String id) {
    
    authorService.deleteAuthorById(id);
}
}
