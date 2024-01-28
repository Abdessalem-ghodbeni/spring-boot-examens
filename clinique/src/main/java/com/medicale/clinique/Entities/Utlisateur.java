package com.medicale.clinique.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "Utlisateur")
public class Utlisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUtilisateur")
    private int idUtilisateur;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;


    @Temporal(TemporalType.DATE)
    private LocalDate dateDebutAbonnement;

    @Temporal(TemporalType.DATE)
    private LocalDate dateFinAbonnement;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    private Bus bus;

}
