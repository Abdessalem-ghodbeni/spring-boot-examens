package com.example.examen_transaction.Repository;

import com.example.examen_transaction.Entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {
}