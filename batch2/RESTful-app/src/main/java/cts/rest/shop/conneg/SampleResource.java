package cts.rest.shop.conneg;

import java.io.File;
import java.net.URI;

import javax.activation.MimetypesFileTypeMap;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import cts.rest.shop.domain.Customer;

/*
 
All media types (star/*)
--------------------------- 
byte[]
java.lang.String
java.io.Reader (inbound only)
java.io.File
javax.activation.DataSource
javax.ws.rs.core.StreamingOutput (outbound only)

XML media types (text/xml, application/xml and application/...+xml)
------------------------------------------------------------------------
javax.xml.transform.Source
javax.xml.bind.JAXBElement
Application supplied JAXB classes (types annotated with @XmlRootElement or@XmlType)

Form content (application/x-www-form-urlencoded)
----------------------------------------------
MultivaluedMap<String,String>

Plain text (text/plain)
-----------------------
java.lang.Boolean
java.lang.Character
java.lang.Number


 
 
 */

@Path("/sample")
public class SampleResource {

	/**
	 * 
	 * @param image
	 * @return
	 * 
	 * 		Using File with a specific media type to produce a response
	 */
	@GET
	@Path("/images/{image}")
	@Produces("image/*")
	public Response getImage(@PathParam("image") String image) {
		File f = new File(image);

		if (!f.exists()) {
			throw new WebApplicationException(404);
		}

		String mt = new MimetypesFileTypeMap().getContentType(f);
		return Response.ok(f, mt).build();
	}

	// ----------------------------------------------------------

	/**
	 * 
	 * @return
	 */

	@GET
	@Produces({ "application/xml", "application/json" })
	public String doGetAsXmlOrJson() {
		// ...
		return "XMLorJSON";
	}

	// Building Responses

	/**
	 * 
	 * @param content
	 * @return
	 * 
	 * 		Returning 201 status code and adding Location header in response to POST request
	 */

	//	@POST
	//	@Consumes("application/xml")
	//	public Response post(String content) {
	//		URI createdUri = URI.create("");
	//		// create(content);
	//		return Response.created(createdUri).build();
	//	}
	
	/**
	 * 
	 * @param content
	 * @return
	 * 
	 * 		Adding an entity body to a custom response
	 * 
	 */
	//	@POST
	//	@Consumes("application/xml")
	//	public Response post(String content) {
	//		URI createdUri = null;
	//		String createdContent = create(content);
	//		return Response.created(createdUri).entity(Entity.text(createdContent)).build();
	//	}
	
	
	

}
