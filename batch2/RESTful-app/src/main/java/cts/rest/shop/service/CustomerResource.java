package cts.rest.shop.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cts.rest.shop.domain.Customer;

public interface CustomerResource {

	Response createCustomer(Customer customer);

	Customer getCustomer(@PathParam("id") int id);

	Response createOrUpdateCustomer(@PathParam("id") int id, Customer customer);

	Customer deleteCustomer(@PathParam("id") int id);

}