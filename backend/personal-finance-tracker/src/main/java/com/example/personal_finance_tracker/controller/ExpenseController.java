package com.example.personal_finance_tracker.controller;

import com.example.personal_finance_tracker.model.Expense;
import com.example.personal_finance_tracker.repository.ExpenseRepository;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.personal_finance_tracker.service.ExpenseService;


import java.time.LocalDate;
import java.util.List;



@RestController
@RequestMapping("/expenses")
@CrossOrigin(origins = "*")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // UPDATE EXPENSE (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> updateExpense(
            @PathVariable Long id,
            @RequestBody Expense expense) {

        Expense updatedExpense = expenseService.updateExpense(id, expense);
        return ResponseEntity.ok(updatedExpense);
    }
}






//
//@RestController
//@RequestMapping("/expenses")
//@CrossOrigin(origins = "*")
//public class ExpenseController {
//
//    private final ExpenseRepository repo;
//
//    public ExpenseController(ExpenseRepository repo) {
//        this.repo = repo;
//    }
//
//    // GET ALL
//    @GetMapping
//    public List<Expense> getAllExpenses() {
//        return repo.findAll();
//    }
//
//    // ADD
//    @PostMapping
//    public Expense addExpense(@Valid @RequestBody Expense expense) {
//        return repo.save(expense);
//    }
//
//    // DELETE
//    @DeleteMapping("/{id}")
//    public void deleteExpense(@PathVariable Long id) {
//        repo.deleteById(id);
//    }
//
//    // ✅ FILTER BY CATEGORY / DATE
//    @GetMapping("/filter")
//    public List<Expense> filterExpenses(
//            @RequestParam(required = false) String category,
//            @RequestParam(required = false) String from,
//            @RequestParam(required = false) String to
//    ) {
//
//        if (category != null) {
//            return repo.findByCategoryIgnoreCase(category);
//
//        }
//
//        if (from != null && to != null) {
//            return repo.findByDateBetween(
//                    LocalDate.parse(from),
//                    LocalDate.parse(to)
//            );
//        }
//
//        return repo.findAll();
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<Expense> updateExpense(
//            @PathVariable Long id,
//            @RequestBody Expense updatedExpense) {
//
//        Expense expense = repo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Expense not found"));
//
//        expense.setTitle(updatedExpense.getTitle());
//        expense.setAmount(updatedExpense.getAmount());
//        expense.setCategory(updatedExpense.getCategory());
//        expense.setDate(updatedExpense.getDate());
//
//        Expense savedExpense = repo.save(expense);
//        return ResponseEntity.ok(savedExpense);
//    }
//
//}




//package com.example.personal_finance_tracker.controller;
//
//import com.example.personal_finance_tracker.model.Expense;
//import com.example.personal_finance_tracker.repository.ExpenseRepository;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/expense")
//@CrossOrigin("*")
//public class ExpenseController {
//
//    private final ExpenseRepository expenseRepository;
//
//    public ExpenseController(ExpenseRepository expenseRepository) {
//        this.expenseRepository = expenseRepository;
//    }
//
//    // ➕ Add Expense
//    @PostMapping("/add")
//    public Expense addExpense(@RequestBody Expense expense) {
//        return expenseRepository.save(expense);
//    }
//
//    // 📄 Get All Expenses
//    @GetMapping("/all")
//    public List<Expense> getAllExpenses() {
//        return expenseRepository.findAll();
//    }
//
//    // 🔍 Get Expense By ID
//    @GetMapping("/{id}")
//    public Expense getExpenseById(@PathVariable Long id) {
//        return expenseRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Expense not found with ID: " + id));
//    }
//
//    // ✏️ Update Expense
//    @PutMapping("/update/{id}")
//    public Expense updateExpense(@PathVariable Long id, @RequestBody Expense updatedExpense) {
//        Expense existing = expenseRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Expense not found with ID: " + id));
//
//        existing.setTitle(updatedExpense.getTitle());
//        existing.setAmount(updatedExpense.getAmount());
//        existing.setCategory(updatedExpense.getCategory());
//        existing.setDate(updatedExpense.getDate());
//
//        return expenseRepository.save(existing);
//    }
//
////    // 🗑 Delete Expense
////    @DeleteMapping("/delete/{id}")
////    public String deleteExpense(@PathVariable Long id) {
////        expenseRepository.deleteById(id);
////        return "Expense deleted successfully!";
////    }
//
//    // DELETE EXPENSE
//    @DeleteMapping("/delete/{id}")
//    public void deleteExpense(@PathVariable Long id) {
//        expenseRepository.deleteById(id);
//    }
//
//
//
//
//}
