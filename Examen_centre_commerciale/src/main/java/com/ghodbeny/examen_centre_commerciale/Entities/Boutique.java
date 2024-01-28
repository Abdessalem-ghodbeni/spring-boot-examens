package com.ghodbeny.examen_centre_commerciale.Entities;

import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Boutique")

public class Boutique implements Serializable {

    @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    private long id;
    @Column(name = "nom")
    private  String nom;
@Enumerated(EnumType.STRING)
    @Column(name="categorie")
    private Categorie categorie;

    @ManyToOne
    private CentreCommerciale centreCommerciale;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Client> clients;
}
