package com.springer.newsletter.server;

import com.springer.newsletter.api.Newsletter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Path("newsletters")
public class Newsletters {

    @GET
    public List<Newsletter> getNewsletter() {
        return new ArrayList<>();
    }
}
