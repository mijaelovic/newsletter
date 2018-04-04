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
