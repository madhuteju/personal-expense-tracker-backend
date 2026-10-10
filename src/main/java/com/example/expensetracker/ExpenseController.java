package com.example.expensetracker;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "*")
public class ExpenseController {

private final ExpenseRepository repository;

public ExpenseController(ExpenseRepository repository) {
    this.repository = repository;
}

@GetMapping
public List<Expense> getAllExpenses() {
    return repository.findAll();
}

@PostMapping
public Expense addExpense(@RequestBody Expense expense) {
    return repository.save(expense);
}

@DeleteMapping("/{id}")
public void deleteExpense(@PathVariable Long id) {
    repository.deleteById(id);
}

}
