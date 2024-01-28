package com.medicale.clinique.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Trajet")
public class Trajet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTrajet")
    private int idTrajet;

    @Column(name = "pointDepart")
    private String pointDepart;
    @JsonIgnore
    @OneToMany(mappedBy = "trajet",cascade = CascadeType.ALL)
    private Set<Bus>buses;


}
