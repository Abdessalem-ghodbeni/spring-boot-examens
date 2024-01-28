package com.example.examen_transaction.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "Compte")
public class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCompte")
    private long idCompte;

    @Enumerated(EnumType.STRING)
    private TypeCompte type;
    @Column(name = "code")
    private long code;
    @Column(name = "solde")
    private double solde;
}
