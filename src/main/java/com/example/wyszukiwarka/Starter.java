package com.example.wyszukiwarka;

import com.example.wyszukiwarka.domain.Book;
import com.example.wyszukiwarka.domain.Books;
import com.example.wyszukiwarka.domain.Request;
import com.example.wyszukiwarka.domain.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Starter implements CommandLineRunner {

    @Autowired
    Library library = new Library();

    @Override
    public void run(String... args) throws Exception {
        library.addBooks(
                new Book("Geografia", "Jan Kowalski", true),
                new Book("Java", "James Gosling", false),
                new Book("Geografia 2", "Jan Kowalski", false)
        );
        System.out.println(library);

        Request[] requests = {
                new Request("author", "an Kowal"),
                new Request("title", "ografia"),
                new Request("author", "Gos")
        };

        for(Request r : requests) {
            System.out.println(r);
            System.out.println(Books.toString(library.find(r))); // wyszukiwanie i wypisywanie znalezionych kiążek
        }
    }
}
