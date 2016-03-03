package cts.rest.shop.service;

import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Singleton;
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
import javax.ws.rs.core.Response;

import org.glassfish.hk2.api.PerLookup;
import org.glassfish.jersey.process.internal.RequestScoped;

import cts.rest.shop.domain.Customer;



//@RequestScoped
//@PerLookup
@Singleton
@Path("/customers")
public class CustomerResourceImpl implements CustomerResource{

	private static Map<Integer, Customer> customerDB = new ConcurrentHashMap<>();
	private static AtomicInteger idCounter = new AtomicInteger(0);

	
	public CustomerResourceImpl() {
		System.out.println("CustomerResource instance created...");
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response createCustomer(Customer customer) {
		customer.setId(idCounter.incrementAndGet());
		customerDB.put(customer.getId(), customer);
		System.out.println("Created cucstomer " + customer.getId());
		Response response = Response.created(URI.create("/customers/" + customer.getId())).build();
		return response;
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Customer getCustomer(@PathParam("id") int id) {
		final Customer customer = customerDB.get(id);
		if (customer == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return customer;
	}

	@PUT
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response createOrUpdateCustomer(@PathParam("id") int id, Customer customer) {

		// if customer dosent exist then create or update

		Customer dbCustomer = customerDB.get(id);

		if (dbCustomer != null) {
			dbCustomer.setFirstName(customer.getFirstName());
			dbCustomer.setLastName(customer.getLastName());

			System.out.println("Updated cucstomer " + customer.getId());
			Response response = Response.ok().build();
			return response;

		} else {
			customer.setId(idCounter.incrementAndGet());
			customerDB.put(customer.getId(), customer);
			System.out.println("Created cucstomer " + customer.getId());
			Response response = Response.created(URI.create("/customers/" + customer.getId())).build();
			return response;
		}

	}

	@DELETE
	@Path("{id}")
	public Customer deleteCustomer(@PathParam("id") int id) {
		final Customer customer = customerDB.remove(id);
		if (customer == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return customer;
	}
	
	
	
	
	// sub-resource URI matching

	@Path("/sub/{type}")
	public GuestCustomerResourceImpl getGuestCustomerResource(@PathParam("type") String type) {
		if (type.equals("guest")) {
			return new GuestCustomerResourceImpl();
		} else {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}

}
