package cts.rest.shop.exception;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import cts.rest.shop.domain.Customer;

@Path("/sample")
public class SampleResource {

	/**
	 * 
	 * 
	 * 
	 * WebApplicationException and Mapping Exceptions to Responses
	 * 
	 * way-1
	 * 
	 */

	//	@Path("customers/{custid}/")
	//	public Customer getItem(@PathParam("custId") String custid) {
	//		Customer c = null;
	//		// c = getItems().get(custid);
	//		if (c == null) {
	//			throw new CustomNotFoundException("Customer, " + custid + ", is not found");
	//		}
	//
	//		return c;
	//	}

	 @Path("customers/{custid}/")
	 public Customer getItem(@PathParam("custId") String custid) {
		 Customer c=null;
		 // c = getItems().get(custid);
		if (c == null) {
			throw new EntityNotFoundException("No customer");
		}

		return c;
	}

}
