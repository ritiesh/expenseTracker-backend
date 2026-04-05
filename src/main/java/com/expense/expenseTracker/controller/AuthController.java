package com.expense.expenseTracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.expenseTracker.config.JwtUtil;
import com.expense.expenseTracker.dto.AuthResponse;
import com.expense.expenseTracker.dto.LoginRequest;
import com.expense.expenseTracker.dto.RegisterRequest;
import com.expense.expenseTracker.entity.User;
import com.expense.expenseTracker.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;
    

    public AuthController(AuthService authService, JwtUtil jwtUtil) {
		super();
		this.authService = authService;
		this.jwtUtil= jwtUtil;
	}


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
            authService.register(request);
            return ResponseEntity.ok("User registered");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
	
	@PostMapping("/login")
	public AuthResponse login(@RequestBody LoginRequest request) {
		User user = authService.login(request);
		String email = user.getEmail();
		String token = jwtUtil.generateToken(email);
		return new AuthResponse(token, user.getId());
	}
}