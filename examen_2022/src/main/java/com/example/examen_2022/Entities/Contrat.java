package com.example.examen_2022.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "Contrat")
public class Contrat  implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContrat")
    private long idContrat;

    @Column(name = "matricule")
    private String matricule;

    @Temporal(TemporalType.DATE)
    private LocalDate dateEffet;

    @Enumerated(EnumType.STRING)
    private TypeContrat type;

}
