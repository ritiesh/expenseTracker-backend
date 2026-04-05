package com.expense.expenseTracker.dto;

import java.time.LocalDate;

public class ExpenseResponse {
    private Long id;
    private Double amount;
    private String category;
    private String description;
    private LocalDate date;
	public Long getId() {
		return id;
	}
	public Double getAmount() {
		return amount;
	}
	public String getCategory() {
		return category;
	}
	public String getDescription() {
		return description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public ExpenseResponse(Long id, Double amount, String category, String description, LocalDate date) {
		super();
		this.id = id;
		this.amount = amount;
		this.category = category;
		this.description = description;
		this.date = date;
	}
	public ExpenseResponse() {
		super();
		
	}
    
    
    
}