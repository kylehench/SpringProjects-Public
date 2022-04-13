package com.kylehench.javadojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kylehench.javadojooverflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{
		
	// this method retrieves all tags from the database
	List<Tag> findAll();
	
	// return tag by name
	Tag findByNameIs(String name);
}