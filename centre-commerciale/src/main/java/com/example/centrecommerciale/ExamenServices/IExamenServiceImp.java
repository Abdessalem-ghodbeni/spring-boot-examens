package com.example.centrecommerciale.ExamenServices;

import com.example.centrecommerciale.Entities.*;
import com.example.centrecommerciale.ExamenRepository.IBoutiqueRepository;
import com.example.centrecommerciale.ExamenRepository.ICentreCommercialeRepository;
import com.example.centrecommerciale.ExamenRepository.IClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Slf4j
@Service
@RequiredArgsConstructor
public class IExamenServiceImp implements IExamenService {

    private final IBoutiqueRepository boutiqueRepository;
    private final ICentreCommercialeRepository centreCommercialeRepository;
    private final IClientRepository clientRepository;

    @Transactional
    @Override
    public void ajoutCentre(CentreCommerciale centre) {

        for (Boutique boutique : centre.getBoutiques()) {
            boutique.setCentreCommerciale(centre);
        }
        centreCommercialeRepository.save(centre);
    }

    @Override
    public void ajouterEtAffecterlisteBoutiques(List<Boutique> lb, Long idCentre) {
        CentreCommerciale centreCommerciale = centreCommercialeRepository.findById(idCentre).orElse(null);
        for (Boutique boutique : lb) {
            boutique.setCentreCommerciale(centreCommerciale);
            boutiqueRepository.save(boutique);
        }
    }

    @Transactional
    @Override
    public void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques) {
//        Set<Boutique> boutiqueSet = new HashSet<>();
//        for (Long id_boutique : idBoutiques) {
//            Boutique boutique = boutiqueRepository.findById(id_boutique).orElse(null);
//            boutiqueSet.add(boutique);
//        }
//        client.setBoutiques(boutiqueSet);
//        clientRepository.save(client);
        clientRepository.save(client);
        for (Long id_boutique:idBoutiques){
            Boutique boutique=boutiqueRepository.findById(id_boutique).orElse(null);
            boutique.getClients().add(client);
        }
    }

    @Override
    public List<Client> listeClients(Long idBoutique) {
        Boutique boutique=boutiqueRepository.findById(idBoutique).orElse(null);
        List<Client> clientList =new ArrayList<>();
       for (Client client:boutique.getClients()){
           clientList.add(client);

       }
       return clientList;

    }

    @Override
    public List<Boutique> listeBoutiques(Long idCentre) {
        CentreCommerciale centreCommerciale=centreCommercialeRepository.findById(idCentre).orElse(null);
        List<Boutique>boutiqueList=new ArrayList<>();
        for(Boutique boutique: centreCommerciale.getBoutiques()){
            boutiqueList.add(boutique);
        }
       return boutiqueList;
    }

    @Override
    public List<Client> listeDeClientsParCategorie(Categorie categorie) {

        return clientRepository.getClientByCategorie(categorie);
    }

    @Scheduled(cron = "*/30 * * * * *")
    @Override
    public void nbreClientParGenre() {
        log.info("nb de client dont le genre masculin est : " + clientRepository.nbrClient(Genre.MASCULIN) );
        log.info("le nbr des client dont le genre est feminin est : "+ clientRepository.nbrClient(Genre.FEMININ));
    }

}
