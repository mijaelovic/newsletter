package com.springer.newsletter.api;

import java.util.List;

public class Book {
    private String title;
    private List<String> categoryCodes;

    public Book()
    {
    }

    public Book(String title, List<String> categoryCodes) {
        this.title = title;
        this.categoryCodes = categoryCodes;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getCategoryCodes() {
        return categoryCodes;
    }
}
