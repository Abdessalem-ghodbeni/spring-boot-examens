package com.example.abdessalem_examen.Entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Washing_Service")
public class Washing_Service implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idService")
    private long idService;

    @Column(name = "price")
    private float price;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToMany(mappedBy = "washing_services",cascade = CascadeType.ALL)
    private Set<Reservation> reservations;
}
