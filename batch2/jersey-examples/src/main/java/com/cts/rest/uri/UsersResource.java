package com.cts.rest.uri;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

@Path("/users/")
public class UsersResource {
 
    @Context
    UriInfo uriInfo;
 
 
    @GET
    @Produces("application/json")
    public Response getUsersAsJsonArray() throws URISyntaxException {
    	
    	// server side - adding links to a response:
    	Response r = Response.ok().
    		    link("http://oracle.com", "parent").
    		    link(new URI("http://jersey.java.net"), "framework").
    		    build();
    	return r;
    	
    	}
}