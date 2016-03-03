package com.cts.rest.interceptors;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * 
 *
 *  Filters
 *  ---------- 
 *
 *	Filters are primarily intended to manipulate
 *	request and response parameters like HTTP headers, URIs and/or HTTP methods
 *
 *  Interceptors
 *  ---------------
 *  
 *  Interceptors are intended to manipulate entities,
 *  via manipulating entity input/output stream
 *
 *
 */

@Path("myresource")
public class MyResource {

	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Got it!";
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String postIt() {
		return "Post it!";
	}
}
