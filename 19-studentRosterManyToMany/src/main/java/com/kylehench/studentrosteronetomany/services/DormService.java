package com.kylehench.studentrosteronetomany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kylehench.studentrosteronetomany.models.Dorm;
import com.kylehench.studentrosteronetomany.repositories.DormRepository;

@Service
public class DormService {
		
	@Autowired
	private DormRepository repository;
	
	// create
    public Dorm create(Dorm newDorm) {
    	return repository.save(newDorm);
    }
    
    // read
    public Dorm read(Long id) {
        Optional<Dorm> optional = repository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
    // read all
    public List<Dorm> readAll() {
        return repository.findAll();
    }
    // update
    public Dorm update(Dorm o) {
    	return repository.save(o);    	
    }
    // delete
	public void delete(Long id) {
		Optional<Dorm> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);
		}
	}
}