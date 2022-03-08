package com.atech.api.service;

import java.util.List;

import com.atech.api.model.CustomerDTO;

public interface CustomerService {
	
	List<CustomerDTO> getAllCustomers();
	
	CustomerDTO getCustomerById(int customerId);
	
	CustomerDTO createNewCustomer(CustomerDTO customerDTO);
	
	CustomerDTO updateCustomer(CustomerDTO customerDTO, int customerId);
	
	void deleteCustomerById(int customerId);
	
	CustomerDTO patchCustomer(CustomerDTO customerDTO, int customerId);

}
