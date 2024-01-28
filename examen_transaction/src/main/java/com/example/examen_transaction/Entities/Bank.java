package com.example.examen_transaction.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Bank")
public class Bank implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBank")
    private long idBank;

    @Column(name = "nom")
    private String nom;

    @Column(name = "agence")
    private String agence;
    @Column(name = "adresse")
    private String adresse;

    @OneToMany
    private Set<Compte> comptes;


}
