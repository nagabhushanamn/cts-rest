package cts.rest.shop.conneg;

import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cts.rest.shop.domain.Customer;

/*
  
 		   conneg basics
           -------------
 
           GET http://example.com/stuff
           Accept: application/xml,application/json
          
          -------------------------------------------------------
         
           Preference Ordering:-
          
           GET http://example.com/stuff
		   Accept: text/*, text/html;level=1,star/*,application/xml
		   
		   1. text/html
		   2. application/xml
		   3. text/*
		   4. star/*
		   
		   -----------------------------------------------------------
		   
		   
		   GET http://example.com/stuff
		   Accept: text/*;q=0.9, start/*;q=0.1, audio/mpeg, application/xml;q=0.5
		   
		   
		   1. audio/mpeg
		   2. text/*
		   3. application/xml 
		   4. star/*
		   
		   
		   ---------------------------------------------------------
		   
		   
		   
		   Language Negotiation
		   
		   GET http://example.com/stuff 
		   Accept-Language: en-us, es, fr
		   
		   
		   GET http://example.com/stuff
		   Accept-Language: fr;q=1.0, es;q=1.0, en=0.1
		    
		   ---------------------------------------------------------
		    
		    
		   Encoding Negotiation
		   
		    
		   GET http://example.com/stuff 
		   Accept-Encoding: gzip, deflate
		   
		   
		   or
		   
		   GET http://example.com/stuff
		   Accept-Encoding: gzip;q=1.0, compress;0.5; deflate;q=0.1
		   
		   
		   -------------------------------------------------------------
		   
		   JAX-RS and Conneg
		   
		   Method Dispatching
		   
		   
		   
		   
		   

 *
 */

@Path("/customers")
public class CustomerResource {
	
	@GET
	@Path("{id}")
	@Produces("application/xml")
	public Customer getCustomerXml(@PathParam("id") int id) {return null;}
	@GET
	@Path("{id}")
	@Produces("text/plain")
	public String getCustomerText(@PathParam("id") int id) {return null;}
	@GET
	@Path("{id}")
	@Produces("application/json")
	public Customer getCustomerJson(@PathParam("id") int id) {return null;}

	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Customer getCustomer(@PathParam("id") int id) {
		Customer customer = new Customer();
		customer.setId(id);
		customer.setFirstName("Nag");
		return customer;
	}

}
