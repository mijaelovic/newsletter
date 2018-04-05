package com.springer.newsletter.server;

import com.springer.newsletter.api.Category;

import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/categories")
public class Categories {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCategory(Category category) {
        EntityManager em = DataService.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            com.springer.newsletter.model.Category parent = null;
            if (category.getSuperCategoryCode() != null) {
                parent = em.find(
                        com.springer.newsletter.model.Category.class,
                        category.getSuperCategoryCode());
            }
            if (em.find(com.springer.newsletter.model.Category.class, category.getCode()) == null)
            {
                em.persist(new com.springer.newsletter.model.Category(
                        category.getCode(), category.getTitle(), parent));
                em.flush();
            }
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
    public List<Category> getCategories() {
        EntityManager em = DataService.getEntityManager();
        try {
            List<Category> ret = new ArrayList<>();
            Query query = em.createQuery("from Category");
            for (Object item: query.getResultList())
            {
                com.springer.newsletter.model.Category cat = (com.springer.newsletter.model.Category)item;
                String superCategoryCode = (cat.getSuperCategory() == null)? null : cat.getSuperCategory().getCode();
                ret.add(new Category(cat.getCode(), cat.getTitle(), superCategoryCode));
            }
            return ret;
        }
        finally {
            em.close();
        }
    }
}