package com.karnan.rentcloud.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

import com.karnan.rentcloud.task.service.RentProcessTaskRunner;

@SpringBootApplication
@EnableTask
public class Application {

	@Bean
	RentProcessTaskRunner getRentProcessTaskRunner() {
		return new RentProcessTaskRunner();
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
