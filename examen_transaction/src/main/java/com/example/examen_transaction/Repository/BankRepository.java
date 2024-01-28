package com.example.examen_transaction.Repository;

import com.example.examen_transaction.Entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
    Bank findByAgence(String agenceBank);

}