package com.example.assurance_examen.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private int idAssurance;

    @Column(name = "designation")
    private String designation;

    @Column(name = "montant")
    private float montant;
@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Beneficiare beneficiare;
@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Contrat contrat;
}
