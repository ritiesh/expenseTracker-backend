package com.expense.expenseTracker.dto;

public class ExpenseRequest{
	
	private Double amount;
	private String description;
	public Double getAmount() {
		return amount;
	}
	public String getDescription() {
		return description;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public ExpenseRequest() {
		super();
		
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ExpenseRequest(Double amount, String description) {
		super();
		this.amount = amount;
		this.description = description;
	}
	
	
}