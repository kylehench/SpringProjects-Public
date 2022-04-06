package com.kylehench.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kylehench.authentication.models.User;
import com.kylehench.authentication.repositories.UserRepository;


@Service
public class UserService {
	
	// private final UserRepository userRepository;
	// public UserService(UserRepository userRepository) {
	// 	this.userRepository = userRepository;
	// }
	
	@Autowired
	private UserRepository repository;

	// create
    public User register(User o) {
    	List<User> users = repository.findByEmail(o.getEmail());
        if(users.size()<1) {
            return repository.save(o);
        } else {
            return null;
        }
    }
    // read
    public User read(Long id) {
        Optional<User> optional = repository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
    // update
    public User update(User o) {
    	return repository.save(o);    	
    }
    // delete
	public void delete(Long id) {
		Optional<User> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);		
		}
	}

}
