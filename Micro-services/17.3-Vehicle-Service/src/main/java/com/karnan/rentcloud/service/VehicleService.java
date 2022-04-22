package com.karnan.rentcloud.service;

import java.util.List;

import com.karnan.rentcloud.model.vehicle.Vehicle;

public interface VehicleService {

	Vehicle save(Vehicle customer);
    Vehicle findById(int id);
    List<Vehicle> findAll();
}
