package com.karnan.rentcloud.profileservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karnan.rentcloud.commons.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
