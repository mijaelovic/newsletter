package com.springer.newsletter.server;

import com.springer.newsletter.api.Subscriber;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/subscribers")
public class Subscribers {

    static List<Subscriber> subscribers = new ArrayList<>();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(Subscriber subscriber) {
        subscribers.add(subscriber);
    }
}