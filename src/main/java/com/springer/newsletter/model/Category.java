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

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="superCategoryCode", referencedColumnName="code")
    private Category superCategory;

    public Category()
    {
    }

    public Category(String code, String title, Category superCategoryCode)
    {
        this.code = code;
        this.title = title;
        this.superCategory = superCategoryCode;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public Category getSuperCategory() {
        return superCategory;
    }
}
