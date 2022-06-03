package com.sepehr.camelrest.camel.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.sepehr.camelrest.model.entity.Customer;
import com.sepehr.camelrest.model.repo.CustomerRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomerRestRouteBuilder extends RouteBuilder {
	
	private final CustomerRepo customerRepo;
	
	@Override
	public void configure() {
		
		from("direct:customers:get")
			.process(new Processor() {
				
				@Override
				public void process(Exchange exchange) throws Exception {
					String customerId = (String) exchange.getMessage().getHeader("customerId");
					if (customerId != null) {
						exchange.getMessage().setBody(customerRepo.findById(customerId));
					}else {
						exchange.getMessage().setBody(customerRepo.findAll());
					}
				}
			});
		
		from("direct:customers:post")
			.process(new Processor() {
				
				@Override
				public void process(Exchange exchange) throws Exception {
					Customer customer = (Customer) exchange.getMessage().getBody();
					customerRepo.save(customer);
				}
			});
		
		from("direct:customers:put")
			.process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				Customer customer = (Customer) exchange.getMessage().getBody();
				customerRepo.update(customer);
			}
		});
		
		from("direct:customers:delete")
			.process(new Processor() {
				
				@Override
				public void process(Exchange exchange) throws Exception {
					String customerId = (String) exchange.getMessage().getHeader("customerId");
					customerRepo.deleteById(customerId);
				}
			});
		
	}

}
