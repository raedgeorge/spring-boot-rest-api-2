package com.atech.api.model;

import java.util.List;

public class CustomerDTOList {
	
	private List<CustomerDTO> customers;
	

	public CustomerDTOList(List<CustomerDTO> customers) {
		this.customers = customers;
	}

	public List<CustomerDTO> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CustomerDTO> customers) {
		this.customers = customers;
	}
	
	

}
