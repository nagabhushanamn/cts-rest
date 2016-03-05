package com.app;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.cts.rest.entity.Product;
import com.cts.rest.entity.ProductList;

public class App {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/pm-rest-server-app").path("products");

		// ProductList products =
		// target.request(MediaType.APPLICATION_XML).get(ProductList.class);
		//
		// for (Product product : products.getList()) {
		// System.out.println(product);
		// }
		//

		Product newProduct = new Product();
		newProduct.setName("New One");
		newProduct.setPrice(100);
		newProduct.setDescription("bla bla");

		target.request(MediaType.TEXT_PLAIN_TYPE).post(Entity.entity(newProduct, MediaType.APPLICATION_XML));
		
		System.out.println("New product posted...");

	}

}
