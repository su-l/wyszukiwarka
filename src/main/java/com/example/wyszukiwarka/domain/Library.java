package com.example.wyszukiwarka.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;


@Component
public class Library {
    private Book[] books;
    @Value("${library.isOnline}")
    private boolean isOnline;
    @Value("${library.offlineMessage}")
    private String offlineMessage;

    @Autowired
    public Library() {}

    public Library(boolean isOnline, String offlineMessage) {  // for junit test
        this.isOnline = isOnline;
        this.offlineMessage = offlineMessage;
    }

    public void addBooks(Book... books) {
        this.books = books;
    }

    public Book[] find(Request request) {
        if(isOnline) {
            List<Book> found = new LinkedList<Book>();
            for (Book b : books) {
                if (request.type().equals(Request.AUTHOR))
                    if (b.author.matches(".*" + request.content() + ".*"))
                        found.add(b);
                if (request.type().equals(Request.TITLE))
                    if (b.title.matches(".*" + request.content() + ".*"))
                        found.add(b);
            }
            return found.toArray(new Book[0]);
        } else {
            System.err.println(offlineMessage);
            return new Book[0];
        }
    }

    @Override
    public String toString() {
       return "Library:" + System.lineSeparator() + Books.toString(books);
    }
}
