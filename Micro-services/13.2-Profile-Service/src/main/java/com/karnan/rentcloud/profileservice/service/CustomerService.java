package com.karnan.rentcloud.profileservice.service;

import java.util.List;

import com.karnan.rentcloud.commons.model.Customer;

public interface CustomerService {
	Customer save(Customer customer);
	Customer fetchById(int profileId);
	List<Customer> fetchAllProfiles();
}
