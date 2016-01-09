package com.shop.services;

import java.net.URI;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.shop.domin.Customer;

//@Path("/customers")
public interface CustomerResource {

	// @POST
	// @Consumes("application/xml")
	// Response createCustomer(Customer customer);

	// @GET
	// @Path("/{id}")
	// @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	// Response getCustomer(@PathParam("id") int id);
	//
	// @PUT
	// @Path("/{id}")
	// @Consumes("application/xml")
	// @Produces("application/xml")
	// Response updateCustomer(@PathParam("id") int id, Customer customer);
	//
	// @DELETE
	// @Path("/{id}")
	// void deleteCustomer(@PathParam("id") int id);

}
