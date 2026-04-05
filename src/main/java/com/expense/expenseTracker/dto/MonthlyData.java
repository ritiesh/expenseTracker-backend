package com.expense.expenseTracker.dto;


public class MonthlyData {
    private String month;
    private Double amount;
	public String getMonth() {
		return month;
	}
	public Double getAmount() {
		return amount;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public MonthlyData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MonthlyData(String month, Double amount) {
		super();
		this.month = month;
		this.amount = amount;
	}
    
    
    
}