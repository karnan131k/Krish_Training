package com.karnan.rentcloud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.karnan.rentcloud.model.DetailResponse;
import com.karnan.rentcloud.model.customer.Customer;
import com.karnan.rentcloud.model.rent.Rent;
import com.karnan.rentcloud.model.vehicle.Vehicle;
import com.karnan.rentcloud.repository.RentRepository;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    RentRepository rentRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Rent save(Rent customer) {
        return rentRepository.save(customer);
    }

    @Override
    public Rent findById(int id) {
    	
        Optional<Rent> rent = rentRepository.findById(id);
        
        if (rent.isPresent()) {
        	return rent.get();
        }else {
        	return new Rent();
        }
    }

    @Override
    public List<Rent> findAll() {
        return rentRepository.findAll();
    }

    @Override
    public DetailResponse findDetailResponse(int id) {

        Rent rent=findById(id);
        Customer customer=getCustomer(rent.getCustomerId());
        Vehicle vehicle= getVehicle(rent.getVehicleId());

        return new DetailResponse(rent,customer,vehicle);
    }

    private Customer getCustomer(int customerId){

        Customer customer=restTemplate.getForObject("http://localhost:8081/services/customers/"+customerId,Customer.class);
        return customer;
    }

    private Vehicle getVehicle(int vehicleId){

    	Vehicle vehicle = restTemplate.getForObject("http://localhost:9191/services/vehicles/"+vehicleId,Vehicle.class);
       return vehicle;

    }
}
