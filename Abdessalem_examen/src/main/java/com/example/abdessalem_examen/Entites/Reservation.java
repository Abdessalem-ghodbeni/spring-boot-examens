package com.example.abdessalem_examen.Entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Reservation")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReservation")
    private long idReservation;

    @Temporal(TemporalType.DATE)
    private LocalDate timereservation;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Worker worker;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Washing_Service> washing_services;

}
