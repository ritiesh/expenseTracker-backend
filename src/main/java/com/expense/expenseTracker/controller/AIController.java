package com.expense.expenseTracker.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.expenseTracker.service.AIService;

@RestController
@RequestMapping("/api/ai")

public class AIController {

    private final AIService aiService;
    
    
    public AIController(AIService aiService) {
		super();
		this.aiService = aiService;
	}


	@PostMapping("/categorize")
    public String categorize(@RequestBody String text) {
        return aiService.categorize(text);
    }
}