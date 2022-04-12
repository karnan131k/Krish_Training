package com.karnan.rentcloud.configconsumer.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
public class MemberProfileConfiguration {

	@Autowired
	Environment environment;
	public String getDefaultModel() {
		System.out.println(environment);
		System.out.println(environment.getProperty("vehicle.default.model"));
		return environment.getProperty("vehicle.default.model");
	}
	
	public String getMinRentPeriod() {
		System.out.println(environment.getProperty("member.rent.min"));
		return environment.getProperty("member.rent.min");
	}
}
