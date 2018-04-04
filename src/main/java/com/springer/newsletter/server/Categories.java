package com.springer.newsletter.server;

import com.springer.newsletter.api.Category;

import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/categories")
public class Categories {

    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2");
        return emf.createEntityManager();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCategory(Category category) {
        EntityManager em = getEntityManager();
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        {
            com.springer.newsletter.model.Category parent = null;
            if (category.getSuperCategoryCode() != null) {
                parent = em.find(
                        com.springer.newsletter.model.Category.class,
                        category.getSuperCategoryCode());
            }
            em.persist(new com.springer.newsletter.model.Category(
                    category.getCode(), category.getTitle(), parent));
            em.flush();
        }
        tr.commit();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getCategories() {
        EntityManager em = getEntityManager();
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        List<Category> tmp = new ArrayList<>();
        {
            Query query = em.createQuery("from Category");
            for (Object item: query.getResultList()) {
                com.springer.newsletter.model.Category cat = (com.springer.newsletter.model.Category)item;
                String superCategoryCode = (cat.getSuperCategory() == null)? null : cat.getSuperCategory().getCode();
                tmp.add(new Category(cat.getCode(), cat.getTitle(), superCategoryCode));
            }
        }
        tr.commit();
        return tmp;
    }
}