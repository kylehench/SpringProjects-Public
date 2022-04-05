package com.kylehench.modelproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

// to update: "ExpenseRepository", "expenseRepository", "Expense"

@Service
public class ExpenseService {

	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	// return all
    public List<Expense> all() {
        return expenseRepository.findAll();
    }
    // create
    public Expense create(Expense o) {
    	return expenseRepository.save(o);
    }
    // read
    public Expense read(Long id) {
        Optional<Expense> optional = expenseRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
    // update
    public Expense update(Expense o) {
    	return expenseRepository.save(o);    	
    }
    // delete
	public void delete(Long id) {
		Optional<Expense> optional = expenseRepository.findById(id);
		if (optional.isPresent()) {
			expenseRepository.deleteById(id);		
		}
	}

}
