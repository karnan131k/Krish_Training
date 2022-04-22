package com.karnan.rentcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EntityScan(basePackages = "com.karnan.rentcloud.model.rent")
@EnableEurekaClient
public class Application {

	@LoadBalanced
	@Bean
    RestTemplate getRestTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
