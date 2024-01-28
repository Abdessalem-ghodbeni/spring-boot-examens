package com.ghodbeny.examen_centre_commerciale.Services;

import com.ghodbeny.examen_centre_commerciale.Entities.Boutique;
import com.ghodbeny.examen_centre_commerciale.Entities.Client;
import com.ghodbeny.examen_centre_commerciale.Repository.IBoutiqueRepository;
import com.ghodbeny.examen_centre_commerciale.Repository.IClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class IClientService implements IClientServices{
    private final IClientRepository clientRepository;
    private final IBoutiqueRepository boutiqueRepository;
    @Override
    @Transactional
    public void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques) {
        Client newClient=clientRepository.save(client);
        for (Long idBoutique:idBoutiques){
            Boutique boutique=boutiqueRepository.findById(idBoutique).orElseThrow(null);
            boutique.getClients().add(newClient);
        }
    }

    @Override
    public Set<Client> listeClients(Long idBoutique) {
        Boutique boutique = boutiqueRepository.findById(idBoutique).orElse(null);
        return boutique.getClients();
    }


//    @Override
//    public Set<Client> listeClients(Long idBoutique) {
//        Boutique boutique=boutiqueRepository.findById(idBoutique).orElseThrow(null);
//
//        return   boutique.getClients();
//    }


}
