package com.example.examen_2022.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Beneficiaire")
public class Beneficiaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBeneficiare")
    private Integer idBeneficiare;
    @Column(name = "cin")
    private Integer cin;

    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;

    @Column(name = "profession")
    private String profession;

    @Column(name = "salaire")
    private float salaire;
@OneToMany(mappedBy = "beneficiaire",cascade = CascadeType.ALL)
private List<Assurance> assurances;

}
