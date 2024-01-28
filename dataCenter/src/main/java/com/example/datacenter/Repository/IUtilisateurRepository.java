package com.example.datacenter.Repository;

import com.example.datacenter.Entities.Utlisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUtilisateurRepository extends JpaRepository<Utlisateur,Integer> {
}
