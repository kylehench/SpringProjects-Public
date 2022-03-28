package com.kylehench.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kylehench.mvc.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	// this method retrieves all the books from the database
	List<Book> findByTitleIs(String title);
	
}