package com.kylehench.bookbroker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kylehench.bookbroker.models.Book;
import com.kylehench.bookbroker.repositories.BookRepository;


@Service
public class BookService {
	
	// private final BookRepository userRepository;
	// public BookService(BookRepository userRepository) {
	// 	this.userRepository = userRepository;
	// }
	
	@Autowired
	private BookRepository repository;

    // create
    public Book save(Book newBook) {
    	return repository.save(newBook);
    }
    
    // read
    public Book read(Long id) {
        Optional<Book> optional = repository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
    // read all
    public List<Book> readAll() {
        return repository.findAll();
    }
    // update
    public Book update(Book o) {
    	return repository.save(o);    	
    }
    // delete
	public void delete(Long id) {
		Optional<Book> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);		
		}
	}
	// available to borrow
	public List<Book> available() {
		return repository.borrowerIsNull();
	}
	// user is borrowing
	public List<Book> borrowedBy(long userId) {
		return repository.findByBorrowerId(userId);
	}

}
