package com.springer.newsletter.server;

import com.springer.newsletter.api.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/books")
public class Books  {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBook(Book book) {
        EntityManager em = DataService.getEntityManager();

        Query query = em.createQuery("from Category c where c.code in :codes");
        query.setParameter("codes", book.getCategoryCodes());
        List<com.springer.newsletter.model.Category> categories = new ArrayList<>();
        for (Object item : query.getResultList())
            categories.add((com.springer.newsletter.model.Category)item);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            em.persist(new com.springer.newsletter.model.Book(
                    book.getTitle(), categories
            ));
            em.flush();
            tx.commit();
        }
        catch (Exception ex) {
            tx.rollback();
            throw ex;
        }
        finally {
            em.close();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooks() {
        EntityManager em = DataService.getEntityManager();

        try {
            List<Book> tmp = new ArrayList<>();
            Query query = em.createQuery("from Book");
            for (Object item: query.getResultList()) {
                com.springer.newsletter.model.Book book = (com.springer.newsletter.model.Book)item;
                List<String> categoryCodes = new ArrayList<>();
                for (com.springer.newsletter.model.Category cat: book.getCategories())
                    categoryCodes.add(cat.getCode());
                tmp.add(new Book(book.getTitle(), categoryCodes));
            }
            return tmp;
        }
        finally {
            em.close();
        }
    }
}