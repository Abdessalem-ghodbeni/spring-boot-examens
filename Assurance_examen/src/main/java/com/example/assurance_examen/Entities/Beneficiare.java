package com.example.assurance_examen.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Beneficiare")
public class Beneficiare implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBenef")
    private int idBenef;

    @Column(name = "cin")
    private int cin;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "profession")
    private String profession;

    @Column(name = "salaire")
    private float salaire;

@OneToMany(mappedBy = "beneficiare",cascade = CascadeType.ALL)
    private Set<Assurance> assurances;






}
