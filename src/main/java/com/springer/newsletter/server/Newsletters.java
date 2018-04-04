package com.springer.newsletter.server;

import com.springer.newsletter.api.Newsletter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/newsletters")
public class Newsletters {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Newsletter> getNewsletter() {
        return new ArrayList<>();
    }
}