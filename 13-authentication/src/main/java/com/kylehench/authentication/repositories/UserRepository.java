package com.kylehench.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.kylehench.authentication.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	// this method retrieves all the Users from the database
    List<User> findAll();
    // this method retrieves all the Users from the database
    List<User> findByEmail(String email);
}
