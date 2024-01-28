package com.example.centrecommerciale.ExamenRepository;

import com.example.centrecommerciale.Entities.Categorie;
import com.example.centrecommerciale.Entities.Client;
import com.example.centrecommerciale.Entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IClientRepository extends JpaRepository<Client, Long> {
    @Query("select client from Client client join client.boutiques boutique where boutique.categorie=:categorie")
    List<Client> getClientByCategorie(@Param("categorie") Categorie categorie);

    @Query("select COUNT(client) from Client client where client.genre=:genre")
    int nbrClient(@Param("genre") Genre genre);

}
