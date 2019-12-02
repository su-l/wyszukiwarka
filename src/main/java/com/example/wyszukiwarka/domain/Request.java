package com.example.wyszukiwarka.domain;

import java.util.Arrays;


public class Request {
    private String type, content;

    public static final String TITLE = "title";
    public static final String AUTHOR = "author";

    private static String[] legal = {AUTHOR, TITLE};

    public Request(String type, String content) throws IllegalArgumentException {
        if( Arrays.asList(legal).contains(type) ) {
            this.type = type;
        } else {
            throw new IllegalArgumentException();
        }
        this.content=content;
    }

    public void printLegal() {
        System.out.println(Arrays.toString(legal));
    }

    @Override
    public String toString() {
        return "Request, type: " + type + ", content: " + content;
    }

    public String type() {
        return type;
    }
    public String content() {
        return content;
    }
}
