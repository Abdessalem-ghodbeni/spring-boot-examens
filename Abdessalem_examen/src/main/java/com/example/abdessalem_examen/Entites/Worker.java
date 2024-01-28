package com.example.abdessalem_examen.Entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Worker")
public class Worker implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAgent")
    private long idAgent;

    @Column(name = "name")
    private String name;

    @Column(name = "nic")
    private String nic;

    @OneToMany(mappedBy = "worker",cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

}
