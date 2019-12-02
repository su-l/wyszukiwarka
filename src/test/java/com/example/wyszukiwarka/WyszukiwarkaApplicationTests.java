package com.example.wyszukiwarka;

import com.example.wyszukiwarka.domain.Library;
import com.example.wyszukiwarka.domain.Request;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;



@SpringBootTest
class WyszukiwarkaApplicationTests {

    @Autowired
    Library library;

    @Test
    void contextLoads() {
    }

    @Value("${library.offlineMessage}")
    String expectedValue;

    private final ByteArrayOutputStream myErr = new ByteArrayOutputStream();

    @Test
    public void libraryTest() {
        System.setErr(new PrintStream(myErr));

        Request r = new Request("author", "whatever");
        library.find(r);

        assertEquals(expectedValue.concat(System.lineSeparator()), myErr.toString());
    }

}
