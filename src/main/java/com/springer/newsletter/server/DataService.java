package com.springer.newsletter.server;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DataService {

    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
