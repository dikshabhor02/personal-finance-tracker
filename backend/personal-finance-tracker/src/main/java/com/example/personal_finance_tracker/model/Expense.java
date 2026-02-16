package com.example.personal_finance_tracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than zero")
    private Double amount;

    @NotBlank(message = "Category is required")
    private String category;

    @NotNull(message = "Date is required")
    private LocalDate date;

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}







//package com.example.personal_finance_tracker.model;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Positive;
//
//import java.time.LocalDate;
//
//@Entity
//public class Expense {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotBlank(message = "Title is required")
//    private String title;
//
//    @NotNull(message = "Amount is required")
//    @Positive(message = "Amount must be greater than zero")
//    private Double amount;
//
//    @NotBlank(message = "Category is required")
//    private String category;
//
//    @NotNull(message = "Date is required")
//    private LocalDate date;
//
//    // Getters & Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public Double getAmount() {
//        return amount;
//    }
//
//    public void setAmount(Double amount) {
//        this.amount = amount;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }
////}








//package com.example.personal_finance_tracker.model;
//
//import jakarta.persistence.*;
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "expenses")
//public class Expense {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String title;
//
//    @Column(nullable = false)
//    private double amount;
//
//    @Column(nullable = false)
//    private String category;
//
//    @Column(nullable = false)
//    private LocalDate date;
//
//    public Expense() {}
//
//    public Expense(String title, double amount, String category, LocalDate date) {
//        this.title = title;
//        this.amount = amount;
//        this.category = category;
//        this.date = (date != null) ? date : LocalDate.now();
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public double getAmount() {
//        return amount;
//    }
//
//    public void setAmount(double amount) {
//        this.amount = amount;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }
//}
//
//
//
//
//
////package com.example.personal_finance_tracker.model;
////
////import jakarta.persistence.*;
////import java.time.LocalDate;
////
////@Entity
////public class Expense {
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    private String title;
////    private double amount;
////    private String category;
////    private LocalDate date;
////
////    public Expense() {}
////
////    public Expense(String title, double amount, String category, LocalDate date) {
////        this.title = title;
////        this.amount = amount;
////        this.category = category;
////        this.date = date;
////    }
////
////    // Getters and Setters
////    public Long getId() {
////        return id;
////    }
////
////    public String getTitle() {
////        return title;
////    }
////
////    public void setTitle(String title) {
////        this.title = title;
////    }
////
////    public double getAmount() {
////        return amount;
////    }
////
////    public void setAmount(double amount) {
////        this.amount = amount;
////    }
////
////    public String getCategory() {
////        return category;
////    }
////
////    public void setCategory(String category) {
////        this.category = category;
////    }
////
////    public LocalDate getDate() {
////        return date;
////    }
////
////    public void setDate(LocalDate date) {
////        this.date = date;
////    }
////}
////
