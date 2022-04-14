package com.kylehench.studentrosteronetomany.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kylehench.studentrosteronetomany.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{
		
	// retrieve all the students from the database
	List<Student> findAll();
}