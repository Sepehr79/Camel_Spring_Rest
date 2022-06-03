package com.sepehr.camelrest.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sepehr.camelrest.model.entity.Customer;

@Component
public class ApplicationRestRouteBuilder extends RouteBuilder {
	
	public static final String REQUEST_GATE = "direct:gate";
	
	@Value("${camel.api.version}")
	private String apiVersion;

	@Override
	public void configure() throws Exception {
		
		rest()
			.path(String.format("/%s/customers", apiVersion))
			.consumes("application/json")
			.produces("application/json")
			
			.get().to("direct:customers:get")
			.get("/{customerId}").to("direct:customers:get")
			
			.post()
			.type(Customer.class)
			.to("direct:customers:post")
			
			.put()
			.type(Customer.class)
			.to("direct:customers:put")
			
			.delete("/{customerId}")
			.to("direct:customers:delete")
			;
			
	}

}
