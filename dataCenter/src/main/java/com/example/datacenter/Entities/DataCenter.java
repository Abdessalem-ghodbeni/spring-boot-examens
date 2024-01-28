package com.example.datacenter.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "DataCenter")
public class DataCenter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDs")
    private int idDs;

    @Column(name = "region")
    private String region;



    @Temporal(TemporalType.DATE)
    private Date dateFabrication;

    @Column(name = "capaciteDisque")
    private int capaciteDisque;

    @Column(name = "espaceLibreDisque")
    private int espaceLibreDisque;
@OneToMany(mappedBy = "dataCenter",cascade = CascadeType.ALL)
    private Set<VirtualMachine> virtualMachines;

}
