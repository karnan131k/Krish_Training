package com.karnan.rentcar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.karnan.rentcar.model.Student;
import com.karnan.rentcar.service.StudentServiceImpl;

@RestController
public class MainController {

	@Autowired
	StudentServiceImpl studentServiceImpl;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String gretting() {
		return "Hello Spring Boot";
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String gretting2() {
		return "Hello Spring Boot from POST";
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public Student save(@RequestBody Student student) {
		return studentServiceImpl.save(student);
	}
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ResponseEntity<Student> fetchStudent(@RequestParam int id) {
		Student student = studentServiceImpl.fetchStudentById(id);
		if(student==null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().body(student);
		}
	}
	
}
