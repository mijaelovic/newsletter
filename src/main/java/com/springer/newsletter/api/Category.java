package com.springer.newsletter.api;

public class Category {
    private String code;
    private String title;
    private String superCategoryCode;

    public Category()
    {
    }

    public Category(String code, String title, String superCategoryCode)
    {
        this.code = code;
        this.title = title;
        this.superCategoryCode = superCategoryCode;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getSuperCategoryCode() {
        return superCategoryCode;
    }
}
