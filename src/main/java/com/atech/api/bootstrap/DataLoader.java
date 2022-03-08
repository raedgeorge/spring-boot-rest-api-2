package com.atech.api.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.atech.api.entity.Customer;
import com.atech.api.repository.CustomerRepository;

@Component
public class DataLoader implements CommandLineRunner{
	
	private final CustomerRepository customerRepository;
	
	public DataLoader(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Customer raed = new Customer();
		raed.setFirstName("raed");
		raed.setLastName("abu sada");
		
		Customer john = new Customer();
		john.setFirstName("john");
		john.setLastName("doe");
		
		Customer chad = new Customer();
		chad.setFirstName("chad");
		chad.setLastName("darby");
		
		Customer mosh = new Customer();
		mosh.setFirstName("mosh");
		mosh.setLastName("hamedani");
		
		Customer tom = new Customer();
		tom.setFirstName("john");
		tom.setLastName("tompson");
		
		
		customerRepository.save(raed);
		customerRepository.save(john);
		customerRepository.save(chad);
		customerRepository.save(mosh);
		customerRepository.save(tom);
		
		System.out.println("Data Loaded to H2 data base, Count = " + customerRepository.count());
	}

}
