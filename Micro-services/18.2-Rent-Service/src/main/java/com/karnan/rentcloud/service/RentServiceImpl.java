package com.karnan.rentcloud.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.karnan.rentcloud.hystrix.CommonHysctrixCommand;
import com.karnan.rentcloud.hystrix.VehicleCommand;
import com.karnan.rentcloud.model.DetailResponse;
import com.karnan.rentcloud.model.customer.Customer;
import com.karnan.rentcloud.model.rent.Rent;
import com.karnan.rentcloud.model.vehicle.Vehicle;
import com.karnan.rentcloud.repository.RentRepository;
import com.netflix.hystrix.HystrixCommand;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    RentRepository rentRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HystrixCommand.Setter setter;
    
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
    
	/* 
	 * Method 1: fallback method 
	 * ==========================
	 * if customer service not available then findDetailResponsefallback() method will call and return the response
	 * this approach is not that match convenience because we can not control every thing in this method
	 * 
	 * @Override
    @HystrixCommand(fallbackMethod = "findDetailResponsefallback")
    public DetailResponse findDetailResponse(int id) {

        Rent rent=findById(id);
        Customer customer=restTemplate.getForObject("http://customer/services/customers/"+id,Customer.class);
        Vehicle vehicle= getVehicle(rent.getVehicleId());

        return new DetailResponse(rent,customer,vehicle);
    }
    
    public DetailResponse findDetailResponsefallback(int id) {
    	return new DetailResponse(new Rent(), new Customer(), new Vehicle());
    }
	 * 
	 * */

    @Override
    public DetailResponse findDetailResponse(int id) throws  InterruptedException, ExecutionException  {

        Rent rent=findById(id);
        Customer customer=getCustomer(rent.getCustomerId());
        Vehicle vehicle= getVehicle(rent.getVehicleId());

        return new DetailResponse(rent,customer,vehicle);
    }
    
    public DetailResponse findDetailResponsefallback(int id) {
    	return new DetailResponse(new Rent(), new Customer(), new Vehicle());
    }

    private Customer getCustomer(int customerId) throws InterruptedException, ExecutionException{

//        Customer customer=restTemplate.getForObject("http://customer/services/customers/"+customerId,Customer.class);
//        return customer;
    	
    	
		/*
		 * method 3 
		 * =========
		 * it's dynamic
		 */        
    	CommonHysctrixCommand<Customer> customerCommonHysctrixCommand 
        	= new CommonHysctrixCommand<Customer>(setter,()->
        {
            return restTemplate.getForObject("http://customer/services/customers/"+customerId,Customer.class);
        },()->{
        	return new Customer();
        });

        Future<Customer> customerFuture=customerCommonHysctrixCommand.queue();
        return customerFuture.get();
    }

    private Vehicle getVehicle(int vehicleId){

//    	Vehicle vehicle = restTemplate.getForObject("http://vehicle/services/vehicles/"+vehicleId,Vehicle.class);
//       return vehicle;
    	
		/*
		 * method 2:
		 * =========
		 * if vehicle service unavailable then this class object will execute and return
		 * default vales with vehicle command
		 */
    	
    	VehicleCommand vehicleCommand= new VehicleCommand(restTemplate,vehicleId);
        return vehicleCommand.execute();

    }
}
