package com.expense.expenseTracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.expenseTracker.dto.ExpenseRequest;
import com.expense.expenseTracker.dto.ExpenseResponse;
import com.expense.expenseTracker.service.ExpenseService;

@RestController
@RequestMapping("/api/expenses")

public class ExpenseController {

    private final ExpenseService expenseService;
    

    public ExpenseController(ExpenseService expenseService) {
		super();
		this.expenseService = expenseService;
	}

	@PostMapping("/{userId}")
    public ExpenseResponse addExpense(
            @PathVariable Long userId,
            @RequestBody ExpenseRequest request) {

        return expenseService.addExpense(userId, request);
    }

    @GetMapping("/{userId}")
    public List<ExpenseResponse> getExpenses(@PathVariable Long userId) {
        return expenseService.getExpenses(userId);
    }
}