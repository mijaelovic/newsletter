package com.springer.newsletter.client;

import com.springer.newsletter.api.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

public class RestClient {

    private WebTarget target;

    public RestClient() {
        Client client = ClientBuilder.newClient();
        target = client.target("http://localhost:8080").path("newsletter").path("rest");
    }

    public void demo() {
        // Create categories
        Category SCI = new Category("SCI", "science");
        Category ENG = new Category("ENG", "engineering", "SCI");
        Category SW = new Category("SW", "software", "ENG");
        Category FP = new Category("FP", "functional_programming", "SW");
        Category OOP = new Category("OOP", "object_oriented_programming", "SW");

        target.path("categories").request().post(Entity.json(SCI));
        target.path("categories").request().post(Entity.json(ENG));
        target.path("categories").request().post(Entity.json(SW));
        target.path("categories").request().post(Entity.json(FP));
        target.path("categories").request().post(Entity.json(OOP));

        // Read categories
        List<Category> categories = target.path("categories").request(MediaType.APPLICATION_JSON).get(
                new GenericType<List<Category>>() {}
        );
        System.out.println("Listing all categories");
        for (Category category: categories)
            System.out.println(category.getTitle());

        // Create books
        Book SCALA = new Book("Programming in Scala", Arrays.asList("FP", "OOP"));
        target.path("books").request().post(Entity.json(SCALA));

        // List books
        List<Book> books = target.path("books").request(MediaType.APPLICATION_JSON).get(
                new GenericType<List<Book>>() {}
        );
        System.out.println("Listing all books");
        for (Book book: books)
        {
            System.out.println(book.getTitle());
            System.out.println(Arrays.toString(book.getCategoryCodes().toArray()));
        }

        // Create subscriber
        Subscriber subscriber = new Subscriber("subscriber@email.com", Arrays.asList("ENG"));
        target.path("subscribers").request().post(Entity.json(subscriber));

        // List subscribers
        List<Subscriber> subscribers = target.path("subscribers").request(MediaType.APPLICATION_JSON).get(
                new GenericType<List<Subscriber>>() {}
        );
        System.out.println("Listing all subscribers");
        for (Subscriber it: subscribers)
            System.out.println(it.getEmail());

        // And finally, list newsletters
        List<Newsletter> newsletters = target.path("newsletters").request(MediaType.APPLICATION_JSON).get(
                new GenericType<List<Newsletter>>() {}
        );
        System.out.println("Listing all newsletters");
        for (Newsletter newsletter: newsletters) {
            System.out.println(newsletter.getRecipient());
            for (BookFeed feed: newsletter.getNotifications())
            {
                System.out.println(feed.getTitle());
                System.out.println(Arrays.toString(feed.getCategoryPaths().toArray()));
            }
        }
    }

    public static void main(String[] args)
    {
        RestClient rest = new RestClient();
        rest.demo();
    }
}
