package com.cts.rest.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.stereotype.Component;

import com.cts.rest.entity.Product;
import com.cts.rest.entity.ProductList;
import com.cts.rest.repository.HibernateProductRepository;
import com.cts.rest.repository.ProductRepository;

@Component
@Path("/products")
// @PermitAll
public class ProductResource {

	 private ProductRepository productRepository = new HibernateProductRepository();

	//	@Autowired
	//	@Qualifier("prodRepo")
	//	private ProductRepository productRepository;

	//@RolesAllowed({ "Admin", "User" })
	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Product get(@PathParam("id") int id, @Context SecurityContext context) {

		// //
		// -------------------------------------------------------------------------------
		//
		// if (context.isUserInRole("Admin")) {
		// System.out.println("Principal in Admin role....");
		// }
		// // //
		// System.out.println(context.isSecure()); // true
		// System.out.println("Current User : " +
		// context.getAuthenticationScheme()); // BASIC
		
		//System.out.println("Current User : " + context.getUserPrincipal().getName()); // Nag

		// -------------------------------------------------------------------------------

		Product product = productRepository.find(id);
		if (null == product) {
			// throw new ProductNotFoundException("Product Not Exist");
			throw new EntityNotFoundException("Product Not Exist");
		}

		return product;
	}

	// @RolesAllowed({ "Admin", "User" })
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public ProductList getAll() {
		List<Product> products = productRepository.findAll();
		ProductList productList = new ProductList();
		productList.setList(products);
		return productList;
	}

	// @RolesAllowed({ "Admin" })
	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response post(Product product) {
		productRepository.save(product);
		return Response.ok().build();
	}

	// @RolesAllowed({ "Admin" })
	@PUT
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response put(@PathParam("id") int id, Product product) {
		product.setId(id);
		productRepository.update(product);
		return Response.ok().build();
	}

	// @RolesAllowed({ "Admin" })
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {
		productRepository.delete(id);
		return Response.ok().build();
	}

}
