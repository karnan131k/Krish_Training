package com.karnan.rentcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karnan.rentcloud.model.vehicle.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {

}
