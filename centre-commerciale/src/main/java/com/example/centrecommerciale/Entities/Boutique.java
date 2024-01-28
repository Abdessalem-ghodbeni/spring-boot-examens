package com.example.centrecommerciale.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Boutique")
public class Boutique implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nom")
    private String nom;

    @Enumerated(EnumType.STRING)
    private Categorie categorie;
@JsonIgnore
    @ManyToOne
private CentreCommerciale centreCommerciale;
    @ManyToMany
    private Set<Client> clients;

}
