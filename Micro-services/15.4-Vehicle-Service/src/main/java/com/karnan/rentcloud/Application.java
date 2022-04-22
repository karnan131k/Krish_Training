package com.karnan.rentcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.karnan.rentcloud.model.vehicle")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
