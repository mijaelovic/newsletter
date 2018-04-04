package com.springer.newsletter.api;

import java.io.Serializable;

public class Category implements Serializable {
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

    public Category(String code, String title)
    {
        this(code, title, null);
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
