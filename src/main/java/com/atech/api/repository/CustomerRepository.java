package com.atech.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atech.api.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
