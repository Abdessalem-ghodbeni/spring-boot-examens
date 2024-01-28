package com.example.datacenter.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "VirtualMachine")
public class VirtualMachine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVm")
    private int idVm;

    @Column(name = "os")
    private String os;

    @Column(name = "tailleDisque")
    private int tailleDisque;

  @Enumerated(EnumType.STRING)
    private Etat etat;

  @ManyToOne
    private DataCenter dataCenter;
}
