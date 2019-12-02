package com.example.wyszukiwarka.domain;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private final ByteArrayOutputStream myErr = new ByteArrayOutputStream();

    String expectedValue="Library is offline. Access denied.";

    @Test
    public void libraryTest() {
        System.setErr(new PrintStream(myErr));

        Library library = new Library(false, expectedValue);
        Request r = new Request("author", "whatever");
        library.find(r);

        assertEquals(expectedValue.concat(System.lineSeparator()), myErr.toString());
    }
}