package com.karnan.rentcloud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karnan.rentcloud.model.customer.Customer;
import com.karnan.rentcloud.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
        	return customer.get();
        }
        else {
        	return new Customer();
        }
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

}
