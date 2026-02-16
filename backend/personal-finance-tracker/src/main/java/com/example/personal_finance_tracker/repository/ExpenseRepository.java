package com.example.personal_finance_tracker.repository;

import com.example.personal_finance_tracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // Case-insensitive category filter
    @Query("SELECT e FROM Expense e WHERE LOWER(e.category) = LOWER(:category)")
    List<Expense> findByCategoryIgnoreCase(@Param("category") String category);

    // Date range filter
    List<Expense> findByDateBetween(LocalDate from, LocalDate to);
}






//package com.example.personal_finance_tracker.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import com.example.personal_finance_tracker.model.Expense;
//
//public interface ExpenseRepository extends JpaRepository<Expense, Long> {
//}

