package com.springer.newsletter.server;

import com.springer.newsletter.api.Subscriber;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Path("subscribers")
public class Subscribers {

    static List<Subscriber> subscribers = new ArrayList<>();

    @POST
    public void post(Subscriber subscriber) {
        subscribers.add(subscriber);
    }
}
