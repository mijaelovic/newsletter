package com.springer.newsletter.server;

import com.springer.newsletter.api.Book;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Path("books")
public class Books {

    static List<Book> books = new ArrayList<>();

    @POST
    public void post(Book book) {
        books.add(book);
    }
}
