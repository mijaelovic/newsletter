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
