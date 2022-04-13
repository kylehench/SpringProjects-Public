package com.kylehench.javadojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kylehench.javadojooverflow.models.Question;
import com.kylehench.javadojooverflow.repositories.QuestionRepository;


@Service
public class QuestionService {
		
	@Autowired
	private QuestionRepository repository;
	
	// create
    public Question create(Question newQuestion) {
    	return repository.save(newQuestion);
    }
    
    // read
    public Question read(Long id) {
        Optional<Question> optional = repository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
    // read all
    public List<Question> readAll() {
        return repository.findAll();
    }
    // update
    public Question update(Question o) {
    	return repository.save(o);    	
    }
    // delete
	public void delete(Long id) {
		Optional<Question> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);
		}
	}
}
