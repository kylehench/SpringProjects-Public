package com.kylehench.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kylehench.dojosandninjas.models.Dojo;
import com.kylehench.dojosandninjas.repositories.DojoRepository;


@Service
public class DojoService {

	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	// return all
    public List<Dojo> all() {
        return dojoRepository.findAll();
    }
    // create
    public Dojo create(Dojo o) {
    	return dojoRepository.save(o);
    }
    // read
    public Dojo read(Long id) {
        Optional<Dojo> optional = dojoRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
    // update
    public Dojo update(Dojo o) {
    	return dojoRepository.save(o);    	
    }
    // delete
	public void delete(Long id) {
		Optional<Dojo> optional = dojoRepository.findById(id);
		if (optional.isPresent()) {
			dojoRepository.deleteById(id);		
		}
	}

}
