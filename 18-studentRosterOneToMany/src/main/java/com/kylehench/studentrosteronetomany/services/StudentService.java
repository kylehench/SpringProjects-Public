package com.kylehench.studentrosteronetomany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kylehench.studentrosteronetomany.models.Student;
import com.kylehench.studentrosteronetomany.repositories.StudentRepository;

@Service
public class StudentService {
		
	@Autowired
	private StudentRepository repository;
	
	// create
    public Student create(Student newStudent) {
    	return repository.save(newStudent);
    }
    
    // read
    public Student read(Long id) {
        Optional<Student> optional = repository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
    // read all
    public List<Student> readAll() {
        return repository.findAll();
    }
    // update
    public Student update(Student o) {
    	return repository.save(o);    	
    }
    // delete
	public void delete(Long id) {
		Optional<Student> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);
		}
	}
}