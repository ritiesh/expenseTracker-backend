package com.expense.expenseTracker.service;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.expense.expenseTracker.dto.DashboardResponse;
import com.expense.expenseTracker.dto.MonthlyData;
import com.expense.expenseTracker.repository.ExpenseRepository;

@Service
public class DashboardService {

    private final ExpenseRepository expenseRepository;
    
    

    public DashboardService(ExpenseRepository expenseRepository) {
		super();
		this.expenseRepository = expenseRepository;
	}

	public DashboardResponse getDashboard(Long userId) {

        // 🔹 Total
        Double total = expenseRepository.getTotalExpense(userId);

        // 🔹 Category Wise
        List<Object[]> categoryData = expenseRepository.getCategoryWise(userId);
        Map<String, Double> categoryMap = new HashMap<>();

        for (Object[] row : categoryData) {
            categoryMap.put((String) row[0], (Double) row[1]);
        }

        // 🔹 Monthly Trend
        List<Object[]> monthlyData = expenseRepository.getMonthlyTrend(userId);
        List<MonthlyData> trend = new ArrayList<>();

        for (Object[] row : monthlyData) {
            int monthNum = (int) row[0];
            String monthName = getMonthName(monthNum);

            trend.add(new MonthlyData(monthName, (Double) row[1]));
        }

        return new DashboardResponse(total, categoryMap, trend);
    }

    private String getMonthName(int month) {
        return Month.of(month).name(); // JANUARY, FEBRUARY...
    }
}