package com.springer.newsletter.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(fetch=FetchType.LAZY, mappedBy="categories")
    private List<Book> books;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="superCategory")
    private List<Category> childrenCategory;

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

    public List<Book> getBooks() {
        return books;
    }

    public List<Category> getChildrenCategory() {
        return childrenCategory;
    }

    public List<String> getCategoryPath() {
        List<String> ret = new ArrayList<>();
        if (getSuperCategory() != null)
            ret.addAll(getSuperCategory().getCategoryPath());
        ret.add(getTitle());
        return ret;
    }
}
