package com.atech.api.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.atech.api.converter.CustomerDTOToCustomer;
import com.atech.api.converter.CustomerToCustomerDTO;
import com.atech.api.entity.Customer;
import com.atech.api.model.CustomerDTO;
import com.atech.api.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private static final String BASE_API = "/api/customers/";
	private final CustomerRepository customerRepository;
	private final CustomerToCustomerDTO customerToCustomerDTO;
	private final CustomerDTOToCustomer customerDTOToCustomer;


	public CustomerServiceImpl(CustomerRepository customerRepository,
			CustomerToCustomerDTO customerToCustomerDTO,
			CustomerDTOToCustomer customerDTOToCustomer) {
			
		this.customerRepository = customerRepository;
		this.customerToCustomerDTO = customerToCustomerDTO;
		this.customerDTOToCustomer = customerDTOToCustomer;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		
		List<CustomerDTO> customerDTOs = new ArrayList<CustomerDTO>();
		
		customerRepository.findAll()
			.forEach(customer -> {
			
			CustomerDTO customerDTO = customerToCustomerDTO.convert(customer);
			customerDTO.setUrl(BASE_API + customer.getId());
			customerDTOs.add(customerDTO);
			});
		
		return customerDTOs;
	}

	@Override
	public CustomerDTO getCustomerById(int customerId) {
		
		Customer customer = customerRepository.findById(customerId).orElse(null);
		
		if (customer != null) {
		customer.setUrl(BASE_API + customerId);
		}
		
		return customerToCustomerDTO.convert(customer);
	}

	@Override
	public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
		
		Customer customer = customerDTOToCustomer.convert(customerDTO);
		
		Customer savedCustomer = customerRepository.save(customer);
		
		CustomerDTO returnCustomerDTO = customerToCustomerDTO.convert(savedCustomer);
		returnCustomerDTO.setUrl(BASE_API + returnCustomerDTO.getId());
		
		return returnCustomerDTO;
	}

	@Override
	public CustomerDTO updateCustomer(CustomerDTO customerDTO, int customerId) {
		
		Customer customer = customerDTOToCustomer.convert(customerDTO);
		
		customer.setId(customerId);
		Customer savedCustomer = customerRepository.save(customer);
		
		CustomerDTO returnCustomerDTO = customerToCustomerDTO.convert(savedCustomer);
		returnCustomerDTO.setUrl(BASE_API + customerId);
		
		return returnCustomerDTO;
	}

	@Override
	public void deleteCustomerById(int customerId) {
			
		customerRepository.deleteById(customerId);
		
	}

	@Override
	public CustomerDTO patchCustomer(CustomerDTO customerDTO, int customerId) {
		
		Customer customer = customerRepository.findById(customerId).orElse(null);
			
		if (customerDTO.getFirstName() == null) {
			customerDTO.setFirstName(customer.getFirstName());
		}
		
		if (customerDTO.getLastName() == null) {
			customerDTO.setLastName(customer.getLastName());
		}
		
		customer = customerDTOToCustomer.convert(customerDTO);
		customer.setId(customerId);
		Customer savedCustomer = customerRepository.save(customer);
		
		CustomerDTO retuCustomerDTO = customerToCustomerDTO.convert(savedCustomer);
		retuCustomerDTO.setUrl(BASE_API + customerId);
		
		return retuCustomerDTO;
	}

}
