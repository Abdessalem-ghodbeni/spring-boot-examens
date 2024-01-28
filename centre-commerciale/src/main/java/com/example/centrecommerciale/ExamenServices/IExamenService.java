package com.example.centrecommerciale.ExamenServices;

import com.example.centrecommerciale.Entities.Boutique;
import com.example.centrecommerciale.Entities.Categorie;
import com.example.centrecommerciale.Entities.CentreCommerciale;
import com.example.centrecommerciale.Entities.Client;

import java.util.List;

public interface IExamenService {
    void ajoutCentre(CentreCommerciale centre);
    void ajouterEtAffecterlisteBoutiques (List<Boutique> lb, Long idCentre);

    void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques);
    List<Client> listeClients(Long idBoutique);

    List<Boutique> listeBoutiques(Long idCentre);
    List<Client> listeDeClientsParCategorie(Categorie categorie);
    void nbreClientParGenre();

}
