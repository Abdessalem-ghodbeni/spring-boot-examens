package com.transport.transport.Repository;

import com.transport.transport.Entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUtlisateurRepository extends JpaRepository<Utilisateur,Integer> {
//    Utilisateur getByNom(String nom);
//    Utilisateur getByPrenom(String prenom);
Utilisateur  findByNomAndPrenom(String nom,String prenom);
}
