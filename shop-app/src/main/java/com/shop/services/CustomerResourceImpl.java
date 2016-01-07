package com.shop.services;

import java.net.URI;
import java.util.concurrent.atomic.AtomicInteger;

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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.glassfish.grizzly.http.util.HttpStatus;
import org.glassfish.hk2.api.PerLookup;
import org.glassfish.jersey.process.internal.RequestScoped;

import com.shop.domin.Customer;

// JAX-RS

//@Path(value = "/customers")
//@RequestScoped
//@Singleton
//@PerLookup
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
	public Response getCustomer(int id,UriInfo uriInfo) {

		// Get customer form DB

		Customer customer = new Customer();
		customer.setId(id);
		customer.setFirstName("Nag");
		customer.setLastName("N");
		customer.setAddress("BLR");

		NewCookie cookie = new NewCookie("cookie", "somevlaue");
		
		// link , customer orders  
		/*
		 *  http://localhost:8080/shop/api/customers/{id}/orders
		 * 
		 */


//		UriBuilder uriBuilder=UriBuilder.fromUri("customers/{id}/orders");
//		UriBuilder clone=uriBuilder.clone();
//		URI uri=clone.build("http://localhost:8080/shop/api/",id);
		
		UriBuilder nextLinkBuilder=uriInfo.getAbsolutePathBuilder();
		nextLinkBuilder.queryParam("start", 0);
		nextLinkBuilder.queryParam("size", 10);
		
		URI next=nextLinkBuilder.build();
		
		System.out.println(next.toString());

		ResponseBuilder builder = Response.ok();
		builder.language("en")
		       .header("some-header", "some-value")
		       .cookie(cookie)
               .link(next, "next")
		       .entity(customer);
		
		
		
		return builder.build();

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

		// if (id != 123) {
		// throw new WebApplicationException(Response.Status.NOT_FOUND);
		// }
		//
		// System.out.println(customer);

		// create
		if (id == 123) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}

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
	public void deleteCustomer(@BeanParam CustomerBeanParam beanParam) {

		System.out.println(beanParam.getCustomerId() + " customer deleted...");

		//
		if (beanParam.getCustomerId() != 123) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}

	}

	// @Override
	// public String getCarDet(String make, PathSegment car, String year) {
	// // TODO Auto-generated method stub
	// String carColor=car.getMatrixParameters().getFirst("color");
	// return null;
	// }

	@Override
	public String getCustomerReport() {
		return "Vendor report";
	}

}
