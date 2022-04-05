package com.kylehench.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kylehench.dojosandninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {

	// this method retrieves all the Ninjas from the database
    List<Ninja> findAll();
    
    // this method retrieves Ninjas with Dojo id
    List<Ninja> findByDojo_id(long id);

}
