package com.springer.newsletter.model;

import javax.persistence.*;

@Entity
@Table(name="category")
public class Category {
    @Id
    @Column(name="code", nullable=false, unique=true)
    private String code;

    @Column(name="title")
    private String title;

    @ManyToOne
    @JoinColumn(name="superCategoryCode", referencedColumnName="code")
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
