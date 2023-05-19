package com.emrygun.quickstart;

import javax.validation.constraints.NotBlank;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(
            @Context UriInfo uriInfo,
            @QueryParam("order") String order,
            @NotBlank @HeaderParam("authorization") String authorization
            ) {

        return String.format("URI: %s - Order: %s - Authorization: %s", uriInfo.getPath(), order, authorization);
    }
}