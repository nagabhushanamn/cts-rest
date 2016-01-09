package com.shop;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import com.shop.services.CustomerResourceImpl;

@ApplicationPath("/")
public class MyApplication extends ResourceConfig {

	public MyApplication() {
		// TODO Auto-generated constructor stub
		super(CustomerResourceImpl.class);
		register(RolesAllowedDynamicFeature.class);
	}

}
