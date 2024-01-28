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
@Table(name = "Client")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nom")
    private String nom;

    @Enumerated(EnumType.STRING)
    private Genre genre;
@JsonIgnore
    @ManyToMany(mappedBy = "clients",cascade = CascadeType.ALL)
    private Set<Boutique>boutiques;
}
