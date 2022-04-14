package com.kylehench.studentrosteronetomany.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kylehench.studentrosteronetomany.models.Course;
import com.kylehench.studentrosteronetomany.models.Student;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{
		
	// retrieve all the Courses from the database
	List<Course> findAll();
	
	// Retrieves a list of any courses a particular student does not belong to.
    List<Course> findByStudentsNotContains(Student student);
}