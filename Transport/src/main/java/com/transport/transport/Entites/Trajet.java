package com.transport.transport.Entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Trajet")
public class Trajet implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTrajet")
    private Integer idTrajet;

    @Column(name = "pointDedepart" )
    private String pointDedepart;

    @OneToMany (mappedBy = "trajet")
    Set<Bus> bus ;


}
