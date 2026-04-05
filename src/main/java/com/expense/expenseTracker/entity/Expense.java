package com.expense.expenseTracker.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "expenses")
public class Expense{
		
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double amount;
	private String category;
	private String description;
	
	private LocalDate date;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	

	public Expense(Long id, Double amount, String category, String description, LocalDate date, User user) {
		super();
		this.id = id;
		this.amount = amount;
		this.category = category;
		this.description = description;
		this.date = date;
		this.user = user;
	}
	
	

	public Expense() {
		super();
	
	}



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


	public User getUser() {
		return user;
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


	public void setUser(User user) {
		this.user = user;
	}
	
	
}