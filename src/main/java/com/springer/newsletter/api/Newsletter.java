package com.springer.newsletter.api;

import java.util.List;

public class Newsletter {
    private String recipient;
    private List<Book> categoryPaths;

    public Newsletter()
    {
    }

    public Newsletter(String recipient, List<Book> categoryPaths)
    {
        this.recipient = recipient;
        this.categoryPaths = categoryPaths;
    }

    public String getRecipient() {
        return recipient;
    }

    public List<Book> getCategoryPaths() {
        return categoryPaths;
    }
}
