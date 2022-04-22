package com.karnan.rentcloud.service;

import java.util.List;

import com.karnan.rentcloud.model.customer.Customer;

public interface CustomerService {

	Customer save(Customer customer);
    Customer findById(int id);
    List<Customer> findAll();
}
