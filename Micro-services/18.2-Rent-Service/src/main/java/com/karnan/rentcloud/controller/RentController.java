package com.karnan.rentcloud.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.karnan.rentcloud.model.Response;
import com.karnan.rentcloud.model.SimpleResponse;
import com.karnan.rentcloud.model.rent.Rent;
import com.karnan.rentcloud.service.RentService;

@RestController
@RequestMapping("/services/rents")
public class RentController {

    @Autowired
    RentService rentService;

    @PostMapping
    public Rent save(@RequestBody Rent rent) {
        return rentService.save(rent);
    }

    @GetMapping(value = "/{id}")
    public Response getRent(@PathVariable int id, @RequestParam(required = false) String type) throws ExecutionException, InterruptedException {

        if(type==null){
            return  new SimpleResponse(rentService.findById(id));
        }else{
         return    rentService.findDetailResponse(id);
        }
    }

    @GetMapping
    public List<Rent> getAllRents() {
        return rentService.findAll();
    }
    
	/*
	 * @RequestMapping("/test") 
	 * public Rent test() { 
	 * 	Rent rent = new Rent();
	 * 	rent.setCustomerId(1); 
	 * 	rent.setCustomerId(12345);
	 * 	rent.setRentFrom(LocalDateTime.now());
	 * 	rent.setRentTill(LocalDateTime.now().plusDays(2));
	 * 	rent.setReturnLocation("colombo"); 
	 * 	rent.setVehicleId(1); 
	 * 	return rent; 
	 * }
	 */
}
