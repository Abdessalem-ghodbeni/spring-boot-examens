package com.example.examen_transaction.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Transaction")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTransaction")
    private long idTransaction;

    @Column(name = "montant")
    private double montant;


    @Enumerated(EnumType.STRING)
    private TypeTransactions type;

    @Temporal(TemporalType.DATE)
    private LocalDate dateTrasaction;
    @ManyToOne
    private Compte compteExpediteur;
    @ManyToOne
    private Compte compteDestinataire;
}
