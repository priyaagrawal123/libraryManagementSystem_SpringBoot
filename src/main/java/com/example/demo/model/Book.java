package com.example.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books") // MongoDB collection name
public class Book {

    @Id
    private ObjectId id; // MongoDB ID field

    private String authorName; // Name of the author
    private String title;      // Title of the book
    private String genre;      // Genre of the book
    private Number publishedYear; // Published year of the book

    // Constructor
    public Book(String authorName, String title, String genre, Number publishedYear) {
        this.authorName = authorName;
        this.title = title;
        this.genre = genre;
        this.publishedYear = publishedYear;
    }

    // Getters and Setters
    public String getId() {
        return id != null ? id.toHexString() : null; // return ObjectId as String
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Number getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Number publishedYear) {
        this.publishedYear = publishedYear;
    }
}
