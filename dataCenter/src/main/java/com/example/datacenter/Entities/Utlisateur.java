package com.example.datacenter.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Utlisateur")
public class Utlisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private int idUser;

    @Column(name = "nomUser")
    private String nomUser;
    @Column(name = "prenomUser")
    private String prenomUser;
    @Column(name = "login")
    private String login;
    @Column(name = "pwd")
    private String pwd;
@OneToMany(cascade = CascadeType.ALL)
   private Set<VirtualMachine> virtualMachines;

}
