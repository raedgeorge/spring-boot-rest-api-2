package com.atech.api.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atech.api.exceptions.CustomerNotFoundException;
import com.atech.api.model.CustomerDTO;
import com.atech.api.model.CustomerDTOList;
import com.atech.api.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(description = "Customer API", name = "Customer API")
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@Operation(summary = "this method is used to list all Customers")
	@GetMapping({"", "/"})
	public CustomerDTOList listAllCustomers(){
		
		return new CustomerDTOList(customerService.getAllCustomers());
	}
	
	
	@Operation(summary = "this method is used to view a Customer by Id")
	@GetMapping("/{id}")
	public CustomerDTO getCustomerById(@PathVariable int id) {
		
		checkIfCustomerExist(id);
		
		return customerService.getCustomerById(id);
	}
	
	
	@Operation(summary = "this method is used to create a new Customer")
	@PostMapping
	public CustomerDTO createNewCustomer(@RequestBody CustomerDTO customerDTO) {
				
		return customerService.createNewCustomer(customerDTO);
	}
	
	@Operation(summary = "this method is used to update a Customer by its Id")
	@PutMapping("/{id}")
	public CustomerDTO updateCustomer(@PathVariable int id, @RequestBody CustomerDTO customerDTO) {
		
		checkIfCustomerExist(id);
		
		return customerService.updateCustomer(customerDTO, id);
	}
	
	
	@Operation(summary = "this method is used to delete a Customer by its Id")
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable int id) {
		
		checkIfCustomerExist(id);
		
		customerService.deleteCustomerById(id);
	}
	
	@Operation(summary = "this method is used to a patch a Customer by its Id")
	@PatchMapping("/{id}")
	public CustomerDTO patchCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable int id) {
		
		checkIfCustomerExist(id);		
		return customerService.patchCustomer(customerDTO, id);
	}
		
	
	private void checkIfCustomerExist(int id) {
		
		if (customerService.getCustomerById(id) == null) {			
			throw new CustomerNotFoundException("Customer not found with Id : " + id);
		}
	}

}
