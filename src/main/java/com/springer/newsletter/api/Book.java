package com.springer.newsletter.api;

import java.io.Serializable;
import java.util.List;

public class Book implements Serializable {
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
