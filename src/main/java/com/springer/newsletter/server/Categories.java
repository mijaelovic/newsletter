package com.springer.newsletter.server;

import com.springer.newsletter.api.Category;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/categories")
public class Categories {

    static List<Category> categories = new ArrayList<>();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCategory(Category category) {
        categories.add(category);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getCategories() {
        return categories;
    }
}