package com.karnan.rentcloud.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.karnan.rentcloud.model.DetailResponse;
import com.karnan.rentcloud.model.rent.Rent;

public interface RentService {

	Rent save(Rent customer);
    Rent findById(int id);
    List<Rent> findAll();
    DetailResponse findDetailResponse(int id) throws ExecutionException, InterruptedException;
}
