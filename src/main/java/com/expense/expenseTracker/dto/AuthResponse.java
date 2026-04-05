package com.expense.expenseTracker.dto;



public class AuthResponse{
	private String token;
	private Long userId;

	public String getToken() {
		return token;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthResponse(String token , Long userId) {
		super();
		this.token = token;
		this.userId = userId;
	}
	
}