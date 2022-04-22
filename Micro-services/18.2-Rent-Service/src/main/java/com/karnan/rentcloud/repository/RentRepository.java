package com.karnan.rentcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karnan.rentcloud.model.rent.Rent;

public interface RentRepository extends JpaRepository<Rent,Integer> {
	
}