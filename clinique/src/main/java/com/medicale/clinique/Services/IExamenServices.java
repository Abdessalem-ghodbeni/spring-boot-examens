package com.medicale.clinique.Services;

import com.medicale.clinique.Entities.Bus;
import com.medicale.clinique.Entities.Trajet;
import com.medicale.clinique.Entities.Utlisateur;

public interface IExamenServices {

    Trajet ajouterTrajet(Trajet trajet);
    Utlisateur ajouterEtudiant (Utlisateur etudiant);

    Bus ajouterBusEtChauffeur(Bus bus);
    Bus AffecterTrajetABus(int idBus,int idTrajet);

    String affecterEtudiantABus(String numImma, String nom,String prenom);

}
