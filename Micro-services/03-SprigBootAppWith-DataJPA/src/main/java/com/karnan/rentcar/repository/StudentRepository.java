package com.karnan.rentcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.karnan.rentcar.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
