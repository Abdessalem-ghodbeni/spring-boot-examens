package com.example.examen_2022.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Getter
@Setter
@Table(name = "Assurance")
public class Assurance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAssurance")
    private Integer idAssurance;
    @Column(name = "designation")
    private String designation;

    @Column(name = "montant")
    private float montant;
@ManyToOne(cascade =CascadeType.ALL)
    private Contrat contrat;

@ManyToOne(cascade = CascadeType.ALL)
    private Beneficiaire beneficiaire;


}
