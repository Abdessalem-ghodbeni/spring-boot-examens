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
@Table(name = "Client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;


    @Column(name = "nom")
    private String nom;

    @Enumerated(EnumType.STRING)
    //pour que les enumetotation seront sauvgarder en tanque chaine de caractere dans la base de données
    @Column(name = "genre")
    private Genre genre;
    @ManyToMany(mappedBy = "clients")
    private Set<Boutique> boutiques;


}
