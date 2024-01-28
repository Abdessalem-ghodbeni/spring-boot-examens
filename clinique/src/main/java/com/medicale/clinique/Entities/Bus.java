package com.medicale.clinique.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Bus")
public class Bus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBus")
    private int idBus;

    @Column(name = "immatriculation")
    private String immatriculation;


    @Temporal(TemporalType.DATE)
    private LocalDate dateMiseEnServices;

    @Column(name = "nbreDeplaceMax")
    private int nbreDeplaceMax;

    @OneToOne(cascade = CascadeType.ALL)
    private Utlisateur chauffeur;

    @OneToMany(mappedBy = "bus",cascade = CascadeType.ALL)
    private Set<Utlisateur> utlisateurs;

    @ManyToOne
    private Trajet trajet;


}
