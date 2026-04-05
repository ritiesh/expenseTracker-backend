package com.expense.expenseTracker.dto;


public class ChatRequest {
    private String question;

	public ChatRequest(String question) {
		super();
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
    
}