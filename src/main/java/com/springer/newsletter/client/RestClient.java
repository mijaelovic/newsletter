package com.springer.newsletter.client;

import com.springer.newsletter.api.Category;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class RestClient {

    private WebTarget target;

    public RestClient() {
        Client client = ClientBuilder.newClient();
        target = client.target("http://localhost:8080").path("newsletter").path("rest");//.path("service");
    }

    public void demo() {
        Category science = new Category("A", "science");
        //Category engineering = new Category("B", "engineering", "A");
        //Category software = new Category("C", "software", "B");
        //target.path("categories").request().post(Entity.json(science));
        //target.path("categories").request().post(Entity.json(engineering));
        //target.path("categories").request().post(Entity.json(software));

        // Testing
        List<Category> categories = target.path("categories").request(MediaType.APPLICATION_JSON).get(
                new GenericType<List<Category>>() {}
        );
        System.out.println("Listing all categories");
        for (int i=0; i<categories.size(); ++i)
            System.out.println(categories.get(i).getTitle());
    }

    public static void main(String[] args)
    {
        RestClient rest = new RestClient();
        rest.demo();
    }
}
