package com.shop.services;

import java.net.URI;

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

import com.shop.domin.Customer;

@Path("/customers")
public interface CustomerResource {

	@POST
	@Consumes("application/xml")
	Response createCustomer(Customer customer);

	@GET
	@Path("{id}")
	@Produces("application/xml")
	Customer getCustomer(@PathParam("id") int id);

	@PUT
	@Path("{id}")
	@Consumes("application/xml")
	@Produces("application/xml")
	Response updateCustomer(@PathParam("id") int id, Customer customer);

	@DELETE
	@Path("{id}")
	void deleteCustomer(@PathParam("id") int id,@Context URI uri);

	// ---------------------------------------------------

	// HTTP Method and URI matching

	// get all customers

	// @GET
	// @Produces("application/xml")
	// String getAllCutomers();

	// @Path expression
	// -------------------

	// get specific customer

	// Template parameters

	// see above example

	// find customer by firstName and lastName

	// GET /customers/Nag-N
	// @Path("{fName}-{lName}")
	// public Customer getCustomer(@PathParam("fName")String
	// firstName,@PathParam("lName")String lastName);

	// Regular Expression

	// GET /customers/1234
	// @Path("{id:\\d+}")
	// Customer getCustomerById(@PathParam("id")String id);

	// // GET : /customers/bill/burke
	// @Path("{id:.+}")
	// Customer getCustomerById(@PathParam("id")String id);

	// GET : /customers/bill/buke/address

	// @Path("{id:.+/address}")
	// Customer getCustomerById(@PathParam("id") String id);

	// URI Encoding

	// // GET /customers/roy%26fielding
	// @Path("roy&fielding")
	// Customer getLOutBestCustomer();

	// -----------------------------------------------------------------

	// JAX-RS Injections

	/*
	 * @PathParam
	 * 
	 * @MatrixParam
	 * 
	 * @QueryParam
	 * 
	 * @FormParam
	 * 
	 * @HeaderParam
	 * 
	 * @CookieParam
	 * 
	 * @Context
	 * 
	 *    to get cuurrent URI complete details on service metmhod
	 * 
	 */

	/*
	 * 1. PathParam
	 * 
	 * GET /customers/123
	 * 
	 * see above examples
	 */

	/*
	 * 2. Matrix Param
	 * 
	 * GET /cars/mercedes/es55;color=balck/2006 or GET /cars/mercedes/es55/2006
	 * 
	 */
	//
	// @GET
	// @Path("cars/{make}/{model}/{year}")
	// String getCarDet(@PathParam("make")String
	// make,@PathParam("model")PathSegment car,@PathParam("year")String year);

	// GET /mercedes/e55;color=black/2006/interior

	// @Path("{model}/{year}")
	// String getMercededDet(@PathParam("model")String
	// model,@PathParam("year")String year,@MatrixParam("color")String
	// modelCcolor);

	/*
	 * 3. QueryParam
	 * 
	 * for filtering resources
	 * 
	 * /customers?start=0&size=10
	 * 
	 * 
	 */

	// @GET
	// public String getAllCustomer(@QueryParam("start") int
	// start,@QueryParam("size")int size);

}
