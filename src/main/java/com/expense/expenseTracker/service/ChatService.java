package com.expense.expenseTracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.expense.expenseTracker.entity.Expense;
import com.expense.expenseTracker.repository.ExpenseRepository;

@Service
public class ChatService {

    private final ExpenseRepository expenseRepository;
    private final AIService aiService;
    
    

    public ChatService(ExpenseRepository expenseRepository, AIService aiService) {
		super();
		this.expenseRepository = expenseRepository;
		this.aiService = aiService;
	}



	public String chat(Long userId, String question) {

        List<Expense> expenses = expenseRepository.findByUserId(userId);

        // 🔹 Convert DB data into readable format
        StringBuilder data = new StringBuilder();

        for (Expense e : expenses) {
            data.append(e.getCategory())
                .append(" - ")
                .append(e.getAmount())
                .append(", ");
        }

        // 🔥 AI Prompt
        String prompt = "You are a financial assistant. Based on this expense data: "
                + data +
                ". Answer this question: " + question;

        return aiService.askAI(prompt); // reuse AI call
    }
}