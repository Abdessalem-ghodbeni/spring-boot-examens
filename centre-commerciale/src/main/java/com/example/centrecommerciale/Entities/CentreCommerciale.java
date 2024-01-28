package com.example.centrecommerciale.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "CentreCommerciale")
public class CentreCommerciale implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nom")
    private String nom;
    @Column(name = "adresse")
    private String adresse;

    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "centreCommerciale",cascade = CascadeType.ALL)
    private Set<Boutique> boutiques;
}
