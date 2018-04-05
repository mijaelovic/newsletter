package com.springer.newsletter.server;

import com.springer.newsletter.api.BookFeed;
import com.springer.newsletter.api.Newsletter;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/newsletters")
public class Newsletters {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Newsletter> getNewsletter() {
        EntityManager em = DataService.getEntityManager();

        try {
            List<Newsletter> tmp = new ArrayList<>();
            Query query = em.createQuery("from Subscriber");
            for (Object item: query.getResultList()) {
                com.springer.newsletter.model.Subscriber subscriber = (com.springer.newsletter.model.Subscriber)item;

                List<BookFeed> notifications = new ArrayList<>();
                // Compute the book feeds
                Set<String> visitedCategoryCodes = new HashSet<>();
                Queue<com.springer.newsletter.model.Category> queue = new LinkedList<>();
                for (com.springer.newsletter.model.Category category: subscriber.getCategories())
                    if (!visitedCategoryCodes.contains(category.getCode())) {
                        visitedCategoryCodes.add(category.getCode());
                        queue.add(category);
                    }
                while (!queue.isEmpty())
                {
                    com.springer.newsletter.model.Category category = queue.poll();
                    for (com.springer.newsletter.model.Book book: category.getBooks()) {

                        List<List<String>> categoryPaths = new ArrayList<>();
                        for (com.springer.newsletter.model.Category bookCategory: book.getCategories())
                            categoryPaths.add(bookCategory.getCategoryPath());

                        notifications.add(new BookFeed(book.getTitle(), categoryPaths));
                    }
                    for (com.springer.newsletter.model.Category child: category.getChildrenCategory())
                        if (!visitedCategoryCodes.contains(child.getCode())) {
                            visitedCategoryCodes.add(category.getCode());
                            queue.add(category);
                        }
                }
                tmp.add(new Newsletter(
                        subscriber.getEmail(), notifications));
            }
            return tmp;
        }
        finally {
            em.close();
        }
    }
}