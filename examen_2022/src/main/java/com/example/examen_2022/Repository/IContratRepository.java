package com.example.examen_2022.Repository;

import com.example.examen_2022.Entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContratRepository extends JpaRepository<Contrat,Integer> {
    Contrat findByMatricule(String matricule);

}
