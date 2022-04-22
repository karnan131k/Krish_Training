package com.karnan.rentcloud.model.rent;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "rent")
@Data
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentId;
    private int customerId;
    private int vehicleId;
    private LocalDateTime rentFrom;
    private LocalDateTime rentTill;
    private int currentOdometer;
    private String returnLocation;

}
