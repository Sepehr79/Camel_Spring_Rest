package com.sepehr.camelrest.camel.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.sepehr.camelrest.model.repo.CustomerRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GetCustomerProcessor implements Processor {

	private final CustomerRepo customerRepo;
	
	@Override
	public void process(Exchange exchange) throws Exception {
		String customerId = (String) exchange.getMessage().getHeader("customerId");
		if (customerId != null) {
			exchange.getMessage().setBody(customerRepo.findById(customerId));
		}else {
			exchange.getMessage().setBody(customerRepo.findAll());
		}
	}

}
