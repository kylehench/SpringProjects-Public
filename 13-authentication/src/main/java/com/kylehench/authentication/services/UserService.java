package com.kylehench.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.kylehench.authentication.models.LoginUser;
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

    // register
    public User register(User newUser, BindingResult result) {
       // Reject if email is taken (present in database)
    	Optional<User> optional = repository.findByEmail(newUser.getEmail());
    	if(optional.isPresent()) {
    		result.rejectValue("email", "EmailTaken", "Email already taken");
    	}
    
        // Reject if password doesn't match confirmation
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!"); }

        
        // Return null if result has errors
    	if (result.hasErrors()) return null;
    
        // Hash and set password, save user to database
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	repository.save(newUser);
    	return newUser;

    }
    
    // login
    public User login(LoginUser newLogin, BindingResult result) {
        // TO-DO: Additional validations!
        // TO-DO - Reject values:
        
    	// Find user in the DB by email
    	Optional<User> optional = repository.findByEmail(newLogin.getEmail());
    	if(optional.isEmpty()) {
    		result.rejectValue("password", "Matches", "Invalid username or password");
    		return null;
    	}
    	User user = optional.get();
        
        // Reject if BCrypt password match fails
    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    		result.rejectValue("password", "Matches", "Invalid username or password");
    		return null;
    	}
        return user;
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
