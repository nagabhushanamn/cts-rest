package com.shop.services;

import java.net.URI;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

import com.shop.domin.Customer;

// JAX-RS

//@Path(value = "/customers")
public class CustomerResourceImpl implements CustomerResource {

	private AtomicInteger idCounter = new AtomicInteger();

	// POST /customers

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shop.services.ICustomerResource#createCustomer(com.shop.domin.
	 * Customer)
	 */
	// @Override
	// @POST
	// @Produces({ MediaType.APPLICATION_XML })
	// @Consumes({ MediaType.APPLICATION_XML })
	public Response createCustomer(Customer customer) {

		// store in DB
		// generate ID
		customer.setId(idCounter.incrementAndGet());

		System.out.println(customer);

		// response

		// HTTP/1.1 201 Creates
		// ContentType : application/xml

		// payload : XML

		return Response.created(URI.create("/customers/" + customer.getId())).build();
	}

	// GET /customers/12
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shop.services.ICustomerResource#getCustomer(int)
	 */
	// @Override
	// @GET
	// @Path("{id}")
	// @Produces({ MediaType.APPLICATION_XML })
	public Customer getCustomer(int id) {

		// Get customer form DB

		Customer customer = new Customer();
		customer.setId(id);
		customer.setFirstName("Nag");
		customer.setLastName("N");
		customer.setAddress("BLR");

		return customer;

	}

	// PUT /customers/123

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shop.services.ICustomerResource#updateCustomer(int,
	 * com.shop.domin.Customer)
	 */
	// @Override
	// @PUT
	// @Path("{id}")
	// @Consumes({ MediaType.APPLICATION_XML })
	// @Produces({ MediaType.APPLICATION_XML })
	public Response updateCustomer(int id, Customer customer) {

		if (id != 123) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}

		System.out.println(customer);

		return Response.ok(customer).build();

	}

	// DELETE

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shop.services.ICustomerResource#deleteCustomer(int)
	 */
	// @Override
	// @DELETE
	// @Path("{id}")
	public void deleteCustomer(int id,URI uri) {
		
		System.out.println(id + " customer deleted...");

	}

	// @Override
	// public String getCarDet(String make, PathSegment car, String year) {
	// // TODO Auto-generated method stub
	// String carColor=car.getMatrixParameters().getFirst("color");
	// return null;
	// }

}
