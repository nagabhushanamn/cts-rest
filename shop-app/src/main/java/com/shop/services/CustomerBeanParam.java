package com.shop.services;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;


public class CustomerBeanParam {
	
	private int customerId;
	
	@Context
	private UriInfo uriInfo;
	
	public CustomerBeanParam(@PathParam("id")int id) {
		// TODO Auto-generated constructor stub
		this.customerId=id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public UriInfo getUriInfo() {
		return uriInfo;
	}

	public void setUriInfo(UriInfo uriInfo) {
		this.uriInfo = uriInfo;
	}
	
	

}
