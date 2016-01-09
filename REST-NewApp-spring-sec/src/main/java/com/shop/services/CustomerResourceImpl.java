package com.shop.services;

import java.net.URI;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Singleton;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.process.internal.RequestScoped;

import com.shop.domin.Customer;

// JAX-RS
@Path(value = "/customers")
//@PermitAll
public class CustomerResourceImpl {

	private AtomicInteger idCounter = new AtomicInteger();

	@RolesAllowed("Admin")
	@POST
	@Consumes("application/xml")
	public Response createCustomer(Customer customer, @Context SecurityContext context) {

		if (context.isUserInRole("Admin")) {
			System.out.println("Principal in Admin role....");
		}

		System.out.println(context.isSecure());

		System.out.println("Current User : " + context.getAuthenticationScheme());
		System.out.println("Current User : " + context.getUserPrincipal().getName());

		customer.setId(idCounter.incrementAndGet());
		System.out.println(customer);

		return Response.created(URI.create("/customers/" + customer.getId())).build();
	}

	// @PermitAll
	@RolesAllowed("User")
	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getCustomer(@PathParam("id") int id, @Context SecurityContext context) {

		System.out.println("Current User : " + context.getUserPrincipal().getName());
		// Get customer form DB

		Customer customer = new Customer();
		customer.setId(id);
		customer.setFirstName("Nag");
		customer.setLastName("N");
		customer.setAddress("BLR");

		ResponseBuilder builder = Response.ok();
		builder.language("en").header("some-header", "some-value").entity(customer);

		return builder.build();

	}

	// @PUT
	// @Path("/{id}")
	// @Consumes("application/xml")
	// @Produces("application/xml")
	// public Response updateCustomer(@PathParam("id")int id,Customer customer)
	// {
	//
	// if (id != 123) {
	// throw new WebApplicationException(Response.Status.NOT_FOUND);
	// }
	//
	// System.out.println(customer);
	//
	// // create
	// // if (id == 123) {
	// // throw new WebApplicationException(Response.Status.CONFLICT);
	// // }
	//
	// return Response.ok(customer).build();
	//
	// }

	@DELETE
	@Path("/{id}")
	public void deleteCustomer(@PathParam("id") int id) {
		System.out.println(id + " customer deleted...");
	}

}
