package cts.rest.shop.media;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/media")
public class MyResource {

	// @GET
	// @Produces("application/json")
	// public MyBean get() {
	// MyBean myBean = new MyBean("Nag", 31);
	// return myBean;
	// }

	// Low-Level

	@GET
	@Produces("application/json")
	public JsonObject get() {
		JsonObject myObject = Json.createObjectBuilder()
		        .add("name", "Agamemnon")
		        .add("age", 32)
		        .build();
		return myObject;
	}

}
