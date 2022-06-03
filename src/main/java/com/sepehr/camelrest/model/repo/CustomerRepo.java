package com.sepehr.camelrest.model.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sepehr.camelrest.model.entity.Customer;

@Repository
public class CustomerRepo {

	private static final List<Customer> CUSTOMERS = new ArrayList<Customer>();
	
	public void save(Customer customer) {
		if (! CUSTOMERS.contains(customer)) {
			CUSTOMERS.add(customer);
		}
	}
	
	public Customer findById(String customerId) {
		return CUSTOMERS.stream().filter(customer -> customer.getId().equals(customerId))
				.findFirst().orElse(null);
	}
	
	public void deleteById(String customerId) {
		Customer customer = findById(customerId);
		if (customer != null) {
			CUSTOMERS.remove(customer);
		}
	}
	
	public void update(Customer customer) {
		deleteById(customer.getId());
		CUSTOMERS.add(customer);
	}
	
	public List<Customer> findAll(){
		return new ArrayList<Customer>(CUSTOMERS);
	}
	
}
