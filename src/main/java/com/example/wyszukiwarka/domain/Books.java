package com.example.wyszukiwarka.domain;

import java.util.Arrays;
import java.util.stream.Collectors;


public class Books {
    public static String toString(Book[] books) {
        return Arrays.stream(books)
                .map(String::valueOf)
                .collect(Collectors.joining("\n","",""));
    }
}
