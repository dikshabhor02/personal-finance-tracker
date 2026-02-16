package com.example.personal_finance_tracker.service;

import com.example.personal_finance_tracker.model.Expense;
import com.example.personal_finance_tracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // UPDATE EXPENSE
    public Expense updateExpense(Long id, Expense newExpense) {

        Expense existingExpense = expenseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Expense not found with id: " + id)
                );

        existingExpense.setTitle(newExpense.getTitle());
        existingExpense.setAmount(newExpense.getAmount());
        existingExpense.setCategory(newExpense.getCategory());
        existingExpense.setDate(newExpense.getDate());

        return expenseRepository.save(existingExpense);
    }
}

