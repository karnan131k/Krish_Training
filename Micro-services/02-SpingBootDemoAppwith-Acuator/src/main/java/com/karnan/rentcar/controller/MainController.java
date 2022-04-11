package com.karnan.rentcar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String gretting() {
		return "Hello Spring Boot";
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String gretting2() {
		return "Hello Spring Boot from POST";
	}
	
}
