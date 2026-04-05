package com.expense.expenseTracker.dto;

import java.util.List;
import java.util.Map;

public class DashboardResponse {

    private Double totalExpense;
    private Map<String, Double> categoryWise;
    private List<MonthlyData> monthlyTrend;
    
    
	public DashboardResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DashboardResponse(Double totalExpense, Map<String, Double> categoryWise, List<MonthlyData> monthlyTrend) {
		super();
		this.totalExpense = totalExpense;
		this.categoryWise = categoryWise;
		this.monthlyTrend = monthlyTrend;
	}
	public Double getTotalExpense() {
		return totalExpense;
	}
	public Map<String, Double> getCategoryWise() {
		return categoryWise;
	}
	public List<MonthlyData> getMonthlyTrend() {
		return monthlyTrend;
	}
	public void setTotalExpense(Double totalExpense) {
		this.totalExpense = totalExpense;
	}
	public void setCategoryWise(Map<String, Double> categoryWise) {
		this.categoryWise = categoryWise;
	}
	public void setMonthlyTrend(List<MonthlyData> monthlyTrend) {
		this.monthlyTrend = monthlyTrend;
	}
    
    
}