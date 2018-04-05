package com.springer.newsletter.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="subscriber")
public class Subscriber {

    @Id
    @Column(name="email", nullable=false, unique=true)
    private String email;

    @OneToMany
    @JoinTable(name="subscriber_category",
        joinColumns=@JoinColumn(name="subscriber_email"),
        inverseJoinColumns=@JoinColumn(name="category_code"))
    private List<Category> categories;

    public Subscriber()
    {
    }

    public Subscriber(String email, List<Category> categories)
    {
        this.email = email;
        this.categories = categories;
    }

    public String getEmail() {
        return email;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
