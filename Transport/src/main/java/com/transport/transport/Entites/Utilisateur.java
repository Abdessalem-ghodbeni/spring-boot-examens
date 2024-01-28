package com.transport.transport.Entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Utilisateur")
public class Utilisateur implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUtilisateur")
    private Integer idUtilisateur;

    @Column(name = "nom" )
    private String nom;

    @Column(name = "prenom" )
    private String prenom;
    @Temporal(TemporalType.DATE)
    private LocalDate dateDebutAbonnement;

    @Temporal(TemporalType.DATE)
    private LocalDate dateFibAbonnement;
    @Enumerated(EnumType.STRING)
    private Role role;

   @ManyToOne
    private  Bus bus;

}
