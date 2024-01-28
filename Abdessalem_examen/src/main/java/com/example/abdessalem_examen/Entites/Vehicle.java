package com.example.abdessalem_examen.Entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Vehicle")
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVehicle")
    private long idVehicle;

    @Column(name = "brand")
    private String brand;

    @Column(name = "immatriculation")
    private String immatriculation;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;


}
