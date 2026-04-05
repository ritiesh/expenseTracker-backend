package com.expense.expenseTracker.service;



import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.expense.expenseTracker.dto.LoginRequest;
import com.expense.expenseTracker.dto.RegisterRequest;
import com.expense.expenseTracker.entity.User;
import com.expense.expenseTracker.repository.UserRepository;


@Service
public class AuthService{
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public void register(RegisterRequest request) {

	    if (userRepository.existsByEmail(request.getEmail())) {
	        throw new RuntimeException("Email already exists");
	    }

	    User user = new User();
	    user.setName(request.getName());
	    user.setEmail(request.getEmail());
	    user.setPassword(passwordEncoder.encode(request.getPassword()));

	    userRepository.save(user);
	}
	
	public User login(LoginRequest request) {
		User user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(()-> new RuntimeException("user not found"));
		
		if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			
			throw new RuntimeException("Invalid Credentials");
			
		}
		
		return user;
	}
}