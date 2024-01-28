package com.example.examen_transaction.Repository;

import com.example.examen_transaction.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction>findByDateTrasaction(LocalDate date);

}