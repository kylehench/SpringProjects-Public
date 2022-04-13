package com.kylehench.javadojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kylehench.javadojooverflow.models.Answer;
import com.kylehench.javadojooverflow.repositories.AnswerRepository;


@Service
public class AnswerService {
		
	@Autowired
	private AnswerRepository repository;
	
	// create
    public Answer create(Answer newAnswer) {
    	return repository.save(newAnswer);
    }
    
    // read
    public Answer read(Long id) {
        Optional<Answer> optional = repository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
    // read all
    public List<Answer> readAll() {
        return repository.findAll();
    }
    // update
    public Answer update(Answer o) {
    	return repository.save(o);    	
    }
    // delete
	public void delete(Long id) {
		Optional<Answer> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);
		}
	}
}
