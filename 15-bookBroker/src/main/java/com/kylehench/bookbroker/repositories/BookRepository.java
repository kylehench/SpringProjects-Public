package com.kylehench.bookbroker.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.kylehench.bookbroker.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	
	// this method retrieves all the users from the database
    List<Book> findAll();
    // this method retrieves one user from the database
    Optional<Book> findById(long id);
    // retrieve books that are available to borrow
    List<Book> borrowerIsNull();
    // retrieve books that user id is borrowing
    List<Book> findByBorrowerId(long borrowerId);
}