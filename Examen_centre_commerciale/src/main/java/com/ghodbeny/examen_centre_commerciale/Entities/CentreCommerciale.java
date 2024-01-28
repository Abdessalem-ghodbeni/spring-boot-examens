package com.ghodbeny.examen_centre_commerciale.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CentreCommerciale")
public class CentreCommerciale implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="nom")
    private String nom;
    @Column(name="login")
    private String login;
    @Column(name="password")
    private String password;
    @Column(name="adresse")
    private String adresse;
    @OneToMany(mappedBy ="centreCommerciale",cascade = CascadeType.ALL)
private Set<Boutique> boutiques;


}
