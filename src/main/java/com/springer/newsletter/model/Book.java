package com.springer.newsletter.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;

    @Column(name="title")
    private String title;

    @OneToMany
    @JoinTable(name="book_categories",
               joinColumns = @JoinColumn(name="book_id"),
               inverseJoinColumns = @JoinColumn(name="category_code"))
    private List<Category> categories;

    public Book()
    {
    }

    public Book(String title, List<Category> categories) {
        this.title = title;
        this.categories = categories;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
