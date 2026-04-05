package com.expense.expenseTracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.expenseTracker.dto.DashboardResponse;
import com.expense.expenseTracker.service.DashboardService;

@RestController
@RequestMapping("/api/dashboard")

public class DashboardController {

    private final DashboardService dashboardService;
    

    public DashboardController(DashboardService dashboardService) {
		super();
		this.dashboardService = dashboardService;
	}


	@GetMapping("/{userId}")
    public DashboardResponse getDashboard(@PathVariable Long userId) {
        return dashboardService.getDashboard(userId);
    }
}