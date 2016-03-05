package com.cts.rest.app;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.TracingConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

public class MyApplication extends ResourceConfig {

	public MyApplication() {

		// Resources.
		packages("com.cts.rest");

		// Logging.
		register(LoggingFilter.class);

		// Registering RolesAllowedDynamicFeature by extending ResourceConfig
		register(RolesAllowedDynamicFeature.class);

		// Tracing support.
		property(ServerProperties.TRACING, TracingConfig.ON_DEMAND.name());

	}
}
