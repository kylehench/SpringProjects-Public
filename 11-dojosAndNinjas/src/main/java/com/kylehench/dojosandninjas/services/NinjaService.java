package com.kylehench.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kylehench.dojosandninjas.models.Ninja;
import com.kylehench.dojosandninjas.repositories.NinjaRepository;


@Service
public class NinjaService {

	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	// return all
    public List<Ninja> all() {
        return ninjaRepository.findAll();
    }
    // create
    public Ninja create(Ninja o) {
    	return ninjaRepository.save(o);
    }
    // read
    public Ninja read(Long id) {
        Optional<Ninja> optional = ninjaRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
    // update
    public Ninja update(Ninja o) {
    	return ninjaRepository.save(o);    	
    }
    // delete
	public void delete(Long id) {
		Optional<Ninja> optional = ninjaRepository.findById(id);
		if (optional.isPresent()) {
			ninjaRepository.deleteById(id);		
		}
	}

}
