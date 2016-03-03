package cts.rest.shop.sample.resources;

import javax.ws.rs.CookieParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Encoded;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/cars")
public class CarService {

	/**
	 * 
	 * 1. PathParam
	 * 
	 * @param make
	 * @param car
	 * @param year
	 * @return
	 * 
	 * 		GET /cars/mercedes/e55;color=black/2006
	 * 
	 */
	
	//	@GET
	//	@Path("/{make}/{model}/{year}")
	//	//@Produces("image/jpeg")
	//	public String getPicture(@PathParam("make") String make, 
	//			                 @PathParam("model") PathSegment car,
	//			                 @PathParam("year") String year) {
	//		String carColor = car.getMatrixParameters().getFirst("color");
	//		return carColor;
	//	}
	
	
	
	/**
	 * 
	 * 2. @Context
	 * 
	 * @param info
	 * @return
	 * 
	 * 
	 * 		GET /cars/mercedes/e55;color=black/2006
	 * 
	 */
	
	
	//	@GET
	//	@Path("/{make}/{model}/{year}")
	//	//@Produces("image/jpeg")
	//	public String getPicture(@Context UriInfo info) {
	//		String make = info.getPathParameters().getFirst("make");
	//		PathSegment model = info.getPathSegments().get(1);
	//		String color = model.getMatrixParameters().getFirst("color");
	//		return make+"-"+color;
	//	}
	
	/**
	 * 3. @MatrixParam
	 * 
	 * @param make
	 * @param model
	 * @param color
	 * @return
	 * 
	 * 
	 * 		GET /cars/mercedes/e55/2006;color=black
	 */
	
	//	@GET
	//	@Path("/{make}/{model}/{year}")
	//	//@Produces("image/jpeg")
	//	public String getPicture(@PathParam("make") String make,
	//			                 @PathParam("model") String model, 
	//			                 @MatrixParam("color") String color){
	//		return make+"-"+color;
	//	 }
	
	/**
	 * 
	 * 4. @QueryParam
	 * 
	 * @param start
	 * @param size
	 * @return
	 * 
	 * 
	 * 		GET /cars?start=0&size=10
	 */
	
	//	@GET
	//	//@Produces("application/xml")
	//	public String getCars(@QueryParam("start") int start,
	//						  @QueryParam("size") int size) {
	//		return "@QueryParam-"+start+"_"+size;
	//	}
	
	/**
	 * 
	 * @param info
	 * @return
	 */
	
	//	@GET
	//	//@Produces("application/xml")
	//	public String getCustomers(@Context UriInfo info) {
	//		String start = info.getQueryParameters().getFirst("start");
	//		String size = info.getQueryParameters().getFirst("size"); 
	//		return "@QueryParam-"+start+"_"+size;
	//	}
	
	/**
	 * 5. @FormParam
	 * 
	 * @param name
	 * @param color
	 * 
	 *  
	 */
	
	
	//	@POST
	//	public void createCar(@FormParam("name") String name,
	//			              @FormParam("color") String color){
	//		System.out.println(name);
	//		System.out.println(color);
	//	}
	
	/**
	 * 
	 * 6. @HeaderParam
	 * 
	 * @param referer
	 * @return
	 * 
	 * 
	 */
	
	//	@GET
	//	@Produces("text/html")
	//	public String get(@HeaderParam("Referer") String referer) {
	//		return "@HeaderParam - "+referer;
	//	}
	
	/**
	 * 
	 * 7. @CookieParam
	 * 
	 * @param custId
	 * @return
	 * 
	 * 
	 */
	
	//	@GET
	//	@Produces("text/html")
	//	public String get(@CookieParam("customerId") int custId) {
	//		return String.valueOf(custId);
	//	}
	//	
	
	/**
	 * 
	 * 8.@DefaultValue 
	 * 
	 * @param start
	 * @param size
	 * @return
	 */
	
	//	@GET
	//  @Produces("application/xml")
	//	public String getCustomers(@DefaultValue("0") @QueryParam("start") int start,
	//			                   @DefaultValue("10") @QueryParam("size") int size){
	//		return "Pagination customer-result";
	//	 }
	
	
	
	
	/**
	 * 
	 * 9. @Encoded
	 * 
	 * @param str
	 * @return
	 * 
	 * 
	 */
	
	
	@GET
	//	@Produces("application/xml")
	public String get(@Encoded @QueryParam("something") String str) {
		return str;
	}
	
	
	
	
	
	/*
	 * Common Functionality
	 * -------------------------
	 * 
	 *  Automatic Java Type Conversion
	 *  
	 *  
	 *  
	 *  
	    a. Primitive type conversion
	   
	    @GET
		@Path("{id}")
		public String get(@PathParam("id") int id) {...}
		
		
		
		b. Java object conversion
		
		@Path("/myservice") public class MyService {
		@GET
		@Produces("text/html")
		public String get(@HeaderParam("Referer") URL referer) {
		... }
		}
		
		
		public enum Color { BLACK,
		BLUE, RED, WHITE, SILVER
		}
		@GET
		@Path("/{model}/{year}")
		@Produces("image/jpeg")
		public Jpeg getPicture(@PathParam("make") String make,
							   @PathParam("model") String model,
							   @MatrixParam("color") Color color
		... }
		
		
		
		c. Collections
		
		GET /customers?orderBy=last&orderBy=first
		
		@GET @Produces("application/xml") 
		public String getCustomers(
									@QueryParam("start") int start, 
									@QueryParam("size") int size, 
									@QueryParam("orderBy") List<String> orderBy) {
		... }
		
		
	 *  
	 * 
	 * 
	 */

}
