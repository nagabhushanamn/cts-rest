package cts.rest.shop.sample.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;

@Path("/customers")
public class CustomerResource {

	// 1. @PathParam

	/**
	 * 
	 * @param id
	 * @return
	 * 
	 * 		GET /customers/1234
	 * 
	 */

	@GET
	@Path("{id}")
	@Produces("application/xml")
	public String getCustomer(@PathParam("id") int id) {
		return "@PathParam -" + id;
	}

	/**
	 * 
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 * 
	 * 		GET /customers/bill-burke
	 */

	@Path("{first}-{last}")
	@GET
	@Produces("application/xml")
	public String getCustomer(@PathParam("first") String firstName, @PathParam("last") String lastName) {
		return "@PathParam -" + firstName + "-" + lastName;
	}

	/**
	 * 
	 * @param addressId
	 * @return
	 * 
	 * 		'Scope of Path Parameters'
	 * 
	 *         GET /customers/123/nag/11
	 * 
	 */

	@Path("{id}/address/{id}")
	@Produces("text/plain")
	@GET
	public String getAddress(@PathParam("id") String addressId) {
		return "@PathParam -" + addressId;
	}

	/**
	 * 
	 * @param make
	 * @param car
	 * @param year
	 * @return
	 * 
	 * GET /e55;color=black/2006
	 * 
	 */

	@GET
	@Path("/{model}/{year}")
	@Produces("image/jpeg")
	public String getPicture(@PathParam("make")
							 String make, 
							 @PathParam("model") PathSegment car,
							 @PathParam("year") String year) {
		String carColor = car.getMatrixParameters().getFirst("color");
		return carColor;
	}
	}


