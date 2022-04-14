package com.kylehench.studentrosteronetomany.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kylehench.studentrosteronetomany.models.Dorm;

@Repository
public interface DormRepository extends CrudRepository<Dorm, Long>{
		
	// retrieve all the DormS from the database
	List<Dorm> findAll();
}