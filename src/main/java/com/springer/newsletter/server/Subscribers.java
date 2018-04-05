package com.springer.newsletter.server;

import com.springer.newsletter.api.Subscriber;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/subscribers")
public class Subscribers {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addSubscriber(Subscriber subscriber) {
        EntityManager em = DataService.getEntityManager();

        Query query = em.createQuery("from Category c where c.code in :codes");
        query.setParameter("codes", subscriber.getCategoryCodes());
        List<com.springer.newsletter.model.Category> categories = new ArrayList<>();
        for (Object item : query.getResultList())
            categories.add((com.springer.newsletter.model.Category)item);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            em.persist(new com.springer.newsletter.model.Subscriber(
                    subscriber.getEmail(), categories
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
    public List<Subscriber> getSubscribers() {
        EntityManager em = DataService.getEntityManager();

        try {
            List<Subscriber> tmp = new ArrayList<>();
            Query query = em.createQuery("from Subscriber");
            for (Object item: query.getResultList()) {
                com.springer.newsletter.model.Subscriber subscriber = (com.springer.newsletter.model.Subscriber)item;
                List<String> categoryCodes = new ArrayList<>();
                for (com.springer.newsletter.model.Category cat: subscriber.getCategories())
                    categoryCodes.add(cat.getCode());
                tmp.add(new Subscriber(subscriber.getEmail(), categoryCodes));
            }
            return tmp;
        }
        finally {
            em.close();
        }
    }
}