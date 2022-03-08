package com.atech.api.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.atech.api.entity.Customer;
import com.atech.api.model.CustomerDTO;

@Component
public class CustomerToCustomerDTO implements Converter<Customer, CustomerDTO>{

	@Override
	public CustomerDTO convert(Customer source) {
		
		if (source == null) {
		return null;
		}
		
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setId(source.getId());
		customerDTO.setFirstName(source.getFirstName());
		customerDTO.setLastName(source.getLastName());
		customerDTO.setUrl(source.getUrl());
		
		return customerDTO;
	}

}
