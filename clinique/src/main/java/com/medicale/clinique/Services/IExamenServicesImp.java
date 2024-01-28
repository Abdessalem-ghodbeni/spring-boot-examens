package com.medicale.clinique.Services;

import com.medicale.clinique.Entities.Bus;
import com.medicale.clinique.Entities.Role;
import com.medicale.clinique.Entities.Trajet;
import com.medicale.clinique.Entities.Utlisateur;
import com.medicale.clinique.Repository.IBusRepository;
import com.medicale.clinique.Repository.ITrajetRepository;
import com.medicale.clinique.Repository.IUtilisateurRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class IExamenServicesImp implements IExamenServices {
    private final IBusRepository busRepository;
    private final ITrajetRepository trajetRepository;
    private final IUtilisateurRepository utilisateurRepository;


    @Override
    public Trajet ajouterTrajet(Trajet trajet) {
        return  trajetRepository.save(trajet);
    }

    @Override
    public Utlisateur ajouterEtudiant(Utlisateur etudiant) {
        return utilisateurRepository.save(etudiant);
    }

    @Override
    @Transactional
    public Bus ajouterBusEtChauffeur(Bus bus) {
//        Utlisateur chauffeur=bus.getChauffeur();
//        chauffeur.setNom(bus.getChauffeur().getNom());
//        chauffeur.setPrenom(bus.getChauffeur().getPrenom());
//        chauffeur.setRole(Role.CHAUFFEUR);
//        bus.setChauffeur(chauffeur);
//
//        return busRepository.save(bus);
        Utlisateur chaffeur=new Utlisateur();
        chaffeur.setRole(Role.CHAUFFEUR);
        chaffeur.setNom(bus.getChauffeur().getNom());
        chaffeur.setPrenom(bus.getChauffeur().getPrenom());
        bus.setChauffeur(chaffeur);
        return    busRepository.save(bus);



    }

    @Override
    @Transactional
    public Bus AffecterTrajetABus(int idBus, int idTrajet) {
        Trajet trajet=trajetRepository.findById(idTrajet).orElse(null);
        Bus bus=busRepository.findById(idBus).orElse(null);
         bus.setTrajet(trajet);
         busRepository.save(bus);
         return bus;

    }

    @Override
    public String affecterEtudiantABus(String numImma, String nom, String prenom) {
        Utlisateur etudiant=utilisateurRepository.findUtlisateurByNomAndAndPrenom(nom,prenom);
         Bus bus =busRepository.findByImmatriculation(numImma);
         String message="";
         if(etudiant!=null && bus!=null){
             if(bus.getNbreDeplaceMax()==bus.getUtlisateurs().size()){
                 message="Bus complet";
             }
             else {
                 message="L'affectation de l'etudiant est effectué avec succées";
                 bus.getUtlisateurs().add(etudiant);
                 busRepository.save(bus);
             }
             return message;

         }else {
             return "verifier vos donnée";
         }

    }
}
