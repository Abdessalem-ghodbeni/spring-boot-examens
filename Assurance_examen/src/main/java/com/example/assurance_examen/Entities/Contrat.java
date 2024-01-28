package com.example.assurance_examen.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Contrat")
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContrat")
    private int idContrat;

    @Column(name = "matricule")
    private String matricule;

    @Temporal(TemporalType.DATE)
    private LocalDate dateNaissance;

    @Enumerated(EnumType.STRING)
    private TypeContrat type;

}
