package com.kylehench.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kylehench.safetravels.models.Expense;
import com.kylehench.safetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {

	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	// returns all the expenses
    public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }
    // create an expense
    public Expense createExpense(Expense e) {
    	return expenseRepository.save(e);
    }
    // retrieves an expense
    public Expense findById(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
    // update expense
    public Expense updateExpense(Expense e) {
    	return expenseRepository.save(e);
    	
    }

}
