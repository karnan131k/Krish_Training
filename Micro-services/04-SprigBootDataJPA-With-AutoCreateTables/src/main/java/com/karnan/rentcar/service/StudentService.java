package com.karnan.rentcar.service;

import java.util.Optional;

import com.karnan.rentcar.model.Student;

public interface StudentService {

	Student save(Student student);
	Student fetchStudentById(int id);
}
