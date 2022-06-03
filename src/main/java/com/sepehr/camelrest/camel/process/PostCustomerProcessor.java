package com.sepehr.camelrest.camel.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.sepehr.camelrest.model.entity.Customer;
import com.sepehr.camelrest.model.repo.CustomerRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PostCustomerProcessor implements Processor {

	private final CustomerRepo customerRepo;
	
	@Override
	public void process(Exchange exchange) throws Exception {
		Customer customer = (Customer) exchange.getMessage().getBody();
		customerRepo.save(customer);
	}

}
