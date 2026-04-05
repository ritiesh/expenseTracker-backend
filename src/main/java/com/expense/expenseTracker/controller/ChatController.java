package com.expense.expenseTracker.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.expenseTracker.dto.ChatRequest;
import com.expense.expenseTracker.service.ChatService;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;
    

    public ChatController(ChatService chatService) {
		super();
		this.chatService = chatService;
	}


	@PostMapping("/{userId}")
    public String chat(
            @PathVariable Long userId,
            @RequestBody ChatRequest request) {

        return chatService.chat(userId, request.getQuestion());
    }
}