package com.codingdojo.pokebooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.pokebooks.models.Expense;
import com.codingdojo.pokebooks.repositories.ExpenseRepository;

@Service
public class ExpenseService {

	private final ExpenseRepository ExpenseRepo;
	
	public ExpenseService(ExpenseRepository expenseRepo) {
		this.ExpenseRepo =  expenseRepo;
	}
	
	
	// ****** find all ********
	public List<Expense> allExpenses(){
		return ExpenseRepo.findAll();
	}
	
	// ****** CREATE ********
	public Expense addExpense(Expense expense) {
		// if the created Expense has no id, MySql will create a new instance
		return ExpenseRepo.save(expense);
	}
	
	// ****** SHOW ONE *******
	public Expense findOneExpense(Long id) {
		Optional<Expense> optionalExpense = ExpenseRepo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}else {
			return null;
		}
	}
	
	// ****** EDIT ********
	public Expense editExpense(Expense expense) {
		// if the created Expense has no id, MySql will create a new instance
		return ExpenseRepo.save(expense);
	}
	
	// ****** DELETE ********
	public void deleteExpense(Long id) {
		ExpenseRepo.deleteById(id);
	}



	
}