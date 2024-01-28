package com.transport.transport.Services;

import com.transport.transport.Entites.Bus;
import com.transport.transport.Entites.Role;
import com.transport.transport.Entites.Trajet;
import com.transport.transport.Entites.Utilisateur;
import com.transport.transport.Repository.IBusRepositort;
import com.transport.transport.Repository.ITrajetRepository;
import com.transport.transport.Repository.IUtlisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class IservicesImp implements Iservices {
    private final ITrajetRepository trajetRepository;
    private final IBusRepositort busRepository;
    private final IUtlisateurRepository utlisateurRepository;

    @Override
    public Trajet ajouterTrajet(Trajet trajet) {
        return trajetRepository.save(trajet);
    }

    @Override
    public Utilisateur ajouterEtudiant(Utilisateur etudiant) {
        return utlisateurRepository.save(etudiant);
    }

    @Transactional
    @Override
    public Bus ajouterBusEtChauffeur(Bus bus) {
        Bus newbus = new Bus();
        Utilisateur chauffeur = new Utilisateur();
        chauffeur.setRole(Role.CHAUFFEUR);
        chauffeur.setNom(bus.getChaffeur().getNom());
        chauffeur.setPrenom(bus.getChaffeur().getPrenom());

        newbus.setChaffeur(chauffeur);

        return busRepository.save(newbus);

    }

    @Transactional
    @Override
    public Bus affecterTrajetBus(int idBus, int idTrajet) {
        Bus busToAffecte = busRepository.findById(idBus).orElseThrow(null);
        Trajet trajet = trajetRepository.findById(idTrajet).orElseThrow(null);
        busToAffecte.setTrajet(trajet);
        return busRepository.save(busToAffecte);
    }

    @Override
    public String affecterEtudiantBus(String numImma, String nom, String prenom) {
        Utilisateur e = utlisateurRepository.findByNomAndPrenom(nom, prenom);
        Bus b = busRepository.findByNumImmatriculation(numImma);
        String Message = "";
        if (e != null && b != null) {

            if (b.getUtlisateurs().size() < b.getNbreDeplaceMax()) {
                e.setBus(b);
                utlisateurRepository.save(e);
                Message = "L affectation de l etudiant est affectuée avec succès";
            } else {
                Message = "Le bus est complet";
            }
            return Message;
        }
        return "verifier vos donnees";
    }

    @Scheduled(cron = "*/30 * * * * *")
    @Override
    public Void annulerAbonnement() {
        List<Utilisateur> etudiants = utlisateurRepository.findAll();
        for (Utilisateur user : etudiants) {

            if (user.getDateFibAbonnement().isBefore(LocalDate.now())) {
                user.setBus(null);
            }
        }
        return null;
    }

}
