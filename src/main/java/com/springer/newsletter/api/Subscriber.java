package com.springer.newsletter.api;

import java.util.List;

public class Subscriber {
    private String email;
    private List<String> categoryCodes;

    public Subscriber()
    {
    }

    public Subscriber(String email, List<String> categoryCodes)
    {
        this.email = email;
        this.categoryCodes = categoryCodes;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getCategoryCodes() {
        return categoryCodes;
    }
}
