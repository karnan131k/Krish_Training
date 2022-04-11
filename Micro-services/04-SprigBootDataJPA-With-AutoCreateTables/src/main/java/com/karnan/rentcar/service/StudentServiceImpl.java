package com.karnan.rentcar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karnan.rentcar.model.Student;
import com.karnan.rentcar.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student fetchStudentById(int id) {
		Optional<Student> student = studentRepository.findById(id);
		if(student.isPresent()) {
			return student.get();
		}
		return null;
	}

}
