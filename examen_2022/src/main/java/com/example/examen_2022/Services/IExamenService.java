package com.example.examen_2022.Services;

import com.example.examen_2022.Entities.Assurance;
import com.example.examen_2022.Entities.Beneficiaire;
import com.example.examen_2022.Entities.Contrat;
import com.example.examen_2022.Entities.TypeContrat;

import java.util.Set;

public interface IExamenService {
    public Beneficiaire ajouterBeneficiaire (Beneficiaire bf);
    public Contrat ajouterContrat (Contrat c);
    public Assurance ajouterAssurance (Assurance a, int cinBf, String matricule);
    public Contrat getContratBf (int idBf);
    public Set<Beneficiaire> getBeneficairesByType (TypeContrat typeContrat);
    public float getMontantBf (int cinBf);
    void statistiques();
}
