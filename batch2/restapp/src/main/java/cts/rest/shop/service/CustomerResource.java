package cts.rest.shop.service;

import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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
import javax.ws.rs.core.Response;

import cts.rest.shop.domain.Customer;

@Path("/customers")
public class CustomerResource {

	private static Map<Integer, Customer> customerDB = new ConcurrentHashMap<Integer, Customer>();
	private static AtomicInteger idCounter = new AtomicInteger();

	/* (non-Javadoc)
	 * @see cts.rest.shop.service.ICustomerResource#createCustomer(cts.rest.shop.domain.Customer)
	 */
	@POST
	@Consumes("application/xml")
	public Response createCustomer(Customer customer) {
		customer.setId(idCounter.incrementAndGet());
		customerDB.put(customer.getId(), customer);
		System.out.println("Created customer " + customer.getId());
		return Response.created(URI.create("/customers/" + customer.getId())).build();
	}

	/* (non-Javadoc)
	 * @see cts.rest.shop.service.ICustomerResource#getCustomer(int)
	 */
	@GET
	@Path("{id}")
	@Produces({"application/xml","application/json"})
	public Customer getCustomer(@PathParam("id") int id) {
		final Customer customer = customerDB.get(id);
		if (customer == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return customer;
	}

	/* (non-Javadoc)
	 * @see cts.rest.shop.service.ICustomerResource#updateCustomer(int, cts.rest.shop.domain.Customer)
	 */
	@PUT
	@Path("{id}")
	@Consumes("application/xml")
	public void updateCustomer(@PathParam("id") int id, Customer update) {
		Customer current = customerDB.get(id);
		if (current == null)
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		current.setFirstName(update.getFirstName());
		current.setLastName(update.getLastName());
		current.setStreet(update.getStreet());
		current.setState(update.getState());
		current.setZip(update.getZip());
		current.setCountry(update.getCountry());
	}

	/* (non-Javadoc)
	 * @see cts.rest.shop.service.ICustomerResource#deleteCustomer(int)
	 */
	@DELETE
	@Path("{id}")
	public Customer deleteCustomer(@PathParam("id") int id) {
		final Customer customer = customerDB.remove(id);
		if (customer == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return customer;
	}

}
