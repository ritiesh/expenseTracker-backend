package com.expense.expenseTracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.expense.expenseTracker.entity.Expense;


@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{
	
	List<Expense>findByUserId(Long userId);
	
	 @Query("SELECT SUM(e.amount) FROM Expense e WHERE e.user.id = :userId")
	    Double getTotalExpense(Long userId);

	   
	    @Query("SELECT e.category, SUM(e.amount) FROM Expense e WHERE e.user.id = :userId GROUP BY e.category")
	    List<Object[]> getCategoryWise(Long userId);

	 
	    @Query("SELECT MONTH(e.date), SUM(e.amount) FROM Expense e WHERE e.user.id = :userId GROUP BY MONTH(e.date)")
	    List<Object[]> getMonthlyTrend(Long userId);
}