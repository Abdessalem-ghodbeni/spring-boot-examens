package com.example.assurance_examen.Services;

import com.example.assurance_examen.Entities.Assurance;
import com.example.assurance_examen.Entities.Beneficiare;
import com.example.assurance_examen.Entities.Contrat;
import com.example.assurance_examen.Entities.TypeContrat;

import java.util.Set;

public interface IExamenServices {

    public Beneficiare ajouterBeneficiaire (Beneficiare bf);
    public Contrat ajouterContrat (Contrat c);
    public Assurance ajouterAssurance (Assurance a, int cinBf, String matricule);
    public Contrat getContratBf (int idBf);
    public Set<Beneficiare> getBeneficairesByType (TypeContrat typeContrat);
    public float getMontantBf (int cinBf);
    void statistiques();
}
