package com.springer.newsletter.server;


import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import java.util.*;

@ApplicationPath("/rest")
public class EndpointApp extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return new HashSet<>(Arrays.asList(
                Books.class,
                Categories.class,
                Newsletters.class,
                Subscribers.class
        ));
    }
}
