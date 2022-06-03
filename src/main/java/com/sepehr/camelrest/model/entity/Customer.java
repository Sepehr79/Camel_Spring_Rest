package com.sepehr.camelrest.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Customer {
	
	
	private String id;
	
	private String name;
	
	private String lastName;
	
	private int age;
	
}
