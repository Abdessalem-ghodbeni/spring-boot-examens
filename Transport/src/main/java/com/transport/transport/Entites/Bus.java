package com.transport.transport.Entites;

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
public class Bus implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBus")
    private Integer idBus;

    @Column(name = "numImmatriculation",unique = true)
    private String numImmatriculation;
    @Temporal(TemporalType.DATE)
    private LocalDate dateMiseEnservice;
    @Column(name = "nbreDeplaceMax")
    private Integer nbreDeplaceMax;

    @ManyToOne
    private Trajet trajet;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Utilisateur chaffeur;
    @OneToMany(mappedBy = "bus")
    private Set<Utilisateur> utlisateurs;





}
