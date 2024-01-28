package com.ghodbeny.examen_centre_commerciale.Services;

import com.ghodbeny.examen_centre_commerciale.Entities.Client;

import java.util.List;
import java.util.Set;

public interface IClientServices {
    void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques);
    Set<Client> listeClients(Long idBoutique);
}
