package com.atech.api.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.atech.api.entity.Customer;
import com.atech.api.model.CustomerDTO;

@Component
public class CustomerDTOToCustomer implements Converter<CustomerDTO, Customer>{

	@Override
	public Customer convert(CustomerDTO source) {
		if (source == null) {
		return null;
		}
		
		Customer customer = new Customer();
		customer.setFirstName(source.getFirstName());
		customer.setLastName(source.getLastName());
		customer.setUrl(source.getUrl());
		
		return customer;
	}

}
