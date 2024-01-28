package com.medicale.clinique.Repository;

import com.medicale.clinique.Entities.Utlisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUtilisateurRepository extends JpaRepository<Utlisateur,Integer> {
    Utlisateur findUtlisateurByNomAndAndPrenom(String nom,String prenom);
}
