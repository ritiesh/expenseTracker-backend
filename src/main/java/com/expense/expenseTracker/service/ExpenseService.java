package com.expense.expenseTracker.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.expense.expenseTracker.dto.ExpenseRequest;
import com.expense.expenseTracker.dto.ExpenseResponse;
import com.expense.expenseTracker.entity.Expense;
import com.expense.expenseTracker.entity.User;
import com.expense.expenseTracker.repository.ExpenseRepository;
import com.expense.expenseTracker.repository.UserRepository;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final AIService aiService;
    
    

    public ExpenseService(ExpenseRepository expenseRepository, UserRepository userRepository,AIService aiService) {
		super();
		this.expenseRepository = expenseRepository;
		this.userRepository = userRepository;
		this.aiService=aiService;
	}

	public ExpenseResponse addExpense(Long userId, ExpenseRequest request) {

        User user = userRepository.findById(userId).orElseThrow();
        
        String category = aiService.categorize(request.getDescription());

        Expense expense = new Expense();
        expense.setAmount(request.getAmount());
        expense.setDescription(request.getDescription());
        expense.setDate(LocalDate.now());
        expense.setCategory(category);
        expense.setUser(user);

        expenseRepository.save(expense);

        return new ExpenseResponse(
                expense.getId(),
                expense.getAmount(),
                expense.getCategory(),
                expense.getDescription(),
                expense.getDate()
        );
    }

    public List<ExpenseResponse> getExpenses(Long userId) {
        return expenseRepository.findByUserId(userId)
                .stream()
                .map(e -> new ExpenseResponse(
                        e.getId(),
                        e.getAmount(),
                        e.getCategory(),
                        e.getDescription(),
                        e.getDate()
                ))
                .toList();
    }
}