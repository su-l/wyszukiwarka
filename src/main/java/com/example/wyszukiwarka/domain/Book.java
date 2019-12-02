package com.example.wyszukiwarka.domain;


public class Book {
    public String title, author;
    public boolean isAvailible;

    public Book(String title, String author, boolean isAvailible) {
        this.title = title;
        this.author = author;
        this.isAvailible = isAvailible;
    }

    @Override
    public String toString() {
        return "Book, author: " + author + ", title: " + title + ", availible? " +isAvailible;
    }
}
