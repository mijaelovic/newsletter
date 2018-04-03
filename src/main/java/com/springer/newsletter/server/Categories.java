package com.springer.newsletter.server;

import com.springer.newsletter.api.Category;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Path("categories")
public class Categories {

    static List<Category> categories = new ArrayList<>();

    @POST
    public void post(Category category) {
        categories.add(category);
    }
}
