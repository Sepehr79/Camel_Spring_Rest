package com.sepehr.camelrest.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRestRouteConfiguration extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		restConfiguration()
			.component("servlet")
			.host("localhost")
			.port(8080)
			.bindingMode(RestBindingMode.auto);		
	}

}
