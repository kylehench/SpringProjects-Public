package com.kylehench.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kylehench.authentication.models.User;
import com.kylehench.authentication.repositories.UserRepository;


@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// create
    public User register(User o) {
    	List<User> users = userRepository.findByEmail(o.getEmail());
        if(users.size()<1) {
            return userRepository.save(o);
        } else {
            return null;
        }
    }
    // read
    public User read(Long id) {
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
    // update
    public User update(User o) {
    	return userRepository.save(o);    	
    }
    // delete
	public void delete(Long id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			userRepository.deleteById(id);		
		}
	}

}
