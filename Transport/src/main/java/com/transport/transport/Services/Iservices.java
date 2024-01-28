package com.transport.transport.Services;

import com.transport.transport.Entites.Bus;
import com.transport.transport.Entites.Trajet;
import com.transport.transport.Entites.Utilisateur;

public interface Iservices {
    Trajet ajouterTrajet(Trajet trajet);
    Utilisateur ajouterEtudiant(Utilisateur etudiant);

    Bus ajouterBusEtChauffeur(Bus bus);

    Bus affecterTrajetBus (int idBus,int idTrajet);
    String affecterEtudiantBus(String numImma,String nom, String prenom);
    Void annulerAbonnement();
}
