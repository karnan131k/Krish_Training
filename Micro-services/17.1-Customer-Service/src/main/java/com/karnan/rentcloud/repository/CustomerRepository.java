package com.karnan.rentcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karnan.rentcloud.model.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
