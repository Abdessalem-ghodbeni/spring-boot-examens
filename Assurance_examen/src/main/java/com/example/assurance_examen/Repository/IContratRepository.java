package com.example.assurance_examen.Repository;

import com.example.assurance_examen.Entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContratRepository extends JpaRepository<Contrat,Integer> {
    Contrat findContratByMatricule(String matricule);
}
