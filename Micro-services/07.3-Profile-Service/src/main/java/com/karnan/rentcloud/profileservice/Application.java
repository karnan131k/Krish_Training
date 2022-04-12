package com.karnan.rentcloud.profileservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
/*
 * application run on "com.karnan.rentcloud.profileservice" package and customer
 * && vehicle entities are in different package. so we need to tell spring boot where the entity are available
 * for scanning that's why we need add @EntityScan(basePackages = "com.karnan.rentcloud.commons.model") annotation
 * 
 * if not mention then will get error like "Unsatisfied dependency expressed"
 */
@EntityScan(basePackages = "com.karnan.rentcloud.commons.model")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
