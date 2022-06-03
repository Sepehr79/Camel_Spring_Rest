package com.sepehr.camelrest.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.sepehr.camelrest.camel.process.DeleteCustomerProcessor;
import com.sepehr.camelrest.camel.process.GetCustomerProcessor;
import com.sepehr.camelrest.camel.process.PostCustomerProcessor;
import com.sepehr.camelrest.camel.process.PutCustomerProcessor;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomerRestRouteBuilder extends RouteBuilder {
	
	private final GetCustomerProcessor getCustomerProcessor;
	private final PostCustomerProcessor postCustomerProcessor;
	private final PutCustomerProcessor putCustomerProcessor;
	private final DeleteCustomerProcessor deleteCustomerProcessor;
	
	@Override
	public void configure() {
		
		from("direct:customers:get").process(getCustomerProcessor);
		
		from("direct:customers:post").process(postCustomerProcessor);
		
		from("direct:customers:put").process(putCustomerProcessor);
		
		from("direct:customers:delete").process(deleteCustomerProcessor);
		
	}

}
