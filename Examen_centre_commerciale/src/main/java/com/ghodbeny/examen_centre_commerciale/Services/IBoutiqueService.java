package com.ghodbeny.examen_centre_commerciale.Services;

import com.ghodbeny.examen_centre_commerciale.Entities.Boutique;
import com.ghodbeny.examen_centre_commerciale.Entities.CentreCommerciale;
import com.ghodbeny.examen_centre_commerciale.Entities.Client;
import com.ghodbeny.examen_centre_commerciale.Repository.IBoutiqueRepository;
import com.ghodbeny.examen_centre_commerciale.Repository.ICentreCommercialeRepository;
import com.ghodbeny.examen_centre_commerciale.Repository.IClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class IBoutiqueService implements IBoutiqueServices {
    private final IBoutiqueRepository iBoutiqueRepository;
    private final ICentreCommercialeRepository centreCommercialeRepository;
    private final IClientRepository clientRepository;

 @Transactional
    @Override
    public void ajouterEtAffecterlisteBoutiques(List<Boutique> lb, Long idCentre) {
        CentreCommerciale centre=centreCommercialeRepository.findById(idCentre).orElseThrow(null);
       List<Boutique>boutiques= iBoutiqueRepository.saveAll(lb);
      for(Boutique boutique:boutiques){
          boutique.setCentreCommerciale(centre);
      }

    }

    @Override
    public List<Boutique> listeBoutiques(Long idCentre) {
        CentreCommerciale centreCommerciale=centreCommercialeRepository.findById(idCentre).orElseThrow(null);
        return (List<Boutique>) centreCommerciale.getBoutiques();
    }
//@Transactional
//    @Override
//    public void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques) {
//    List<Boutique> boutiques = iBoutiqueRepository.findAllById(idBoutiques);
//    Client client1 = clientRepository.save(client);
//    client1.setBoutiques((Set<Boutique>) boutiques);
//}
//@Transactional
//@Override
//public void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques) {
//    List<Boutique> boutiques = iBoutiqueRepository.findAllById(idBoutiques);
//    Client client1 = clientRepository.save(client);
//    client1.setBoutiques(new HashSet<>(boutiques));
//
//    // Ajouter le client aux boutiques
//    for (Boutique boutique : boutiques) {
//        boutique.getClients().add(client1);
//    }
//}

}
