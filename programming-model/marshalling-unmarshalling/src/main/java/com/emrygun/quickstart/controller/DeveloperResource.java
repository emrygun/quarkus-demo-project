package com.emrygun.quickstart;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class DeveloperResource {

    private static final List<Developer> developers = new ArrayList<>();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String addDeveloper() {
        return "Hello There";
    }
}