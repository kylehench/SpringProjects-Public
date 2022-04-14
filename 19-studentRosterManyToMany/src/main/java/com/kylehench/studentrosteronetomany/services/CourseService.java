package com.kylehench.studentrosteronetomany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kylehench.studentrosteronetomany.models.Course;
import com.kylehench.studentrosteronetomany.models.Student;
import com.kylehench.studentrosteronetomany.repositories.CourseRepository;

@Service
public class CourseService {
		
	@Autowired
	private CourseRepository repository;
	
	// create
    public Course create(Course newCourse) {
    	return repository.save(newCourse);
    }
    
    // read
    public Course read(Long id) {
        Optional<Course> optional = repository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
    // read all
    public List<Course> readAll() {
        return repository.findAll();
    }
    // read not in student
    public List<Course> readNotInStudent(Student student) {
    	return repository.findByStudentsNotContains(student);
    }
    // update
    public Course update(Course o) {
    	return repository.save(o);    	
    }
    // delete
	public void delete(Long id) {
		Optional<Course> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);
		}
	}
}