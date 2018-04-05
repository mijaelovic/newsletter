package com.springer.newsletter.api;

import java.util.List;

public class BookFeed {
    private String title;
    private List<List<String>> categoryPaths;

    public BookFeed()
    {
    }

    public BookFeed(String title, List<List<String>> categoryPaths) {
        this.title = title;
        this.categoryPaths = categoryPaths;
    }

    public String getTitle() {
        return title;
    }

    public List<List<String>> getCategoryPaths() {
        return categoryPaths;
    }
}
