package com.example.examen_2022.Controller;

import com.example.examen_2022.Entities.Assurance;
import com.example.examen_2022.Entities.Beneficiaire;
import com.example.examen_2022.Entities.Contrat;
import com.example.examen_2022.Entities.TypeContrat;
import com.example.examen_2022.Services.ExamenServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController

@RequiredArgsConstructor
@RequestMapping(path = "/examen")
public class ExamenController {
    private final ExamenServiceImp examenServiceImp;

    @PostMapping(path = "add/beneficiaire")
    public Beneficiaire ajouterBeneficiaire(Beneficiaire bf) {
        return examenServiceImp.ajouterBeneficiaire(bf);
    }

    @PostMapping(path = "add/contrat")
    public Contrat ajouterContrat(Contrat contrat) {
        return examenServiceImp.ajouterContrat(contrat);
    }

    @PostMapping(path = "add/assurance/{cinBf}/{matricule}")
    public Assurance ajouterAssurance(@PathVariable("cinBf") int cinBf,@PathVariable("matricule") String matricule, Assurance a) {
        return examenServiceImp.ajouterAssurance(a,cinBf,matricule);
    }
    @GetMapping(path = "retirive/contrat/ancien/{idBn}")
    public Contrat recupererContratLePlusAncien(@PathVariable("idBn") Integer idBn){
        return examenServiceImp.getContratBf(idBn);
    }

    @GetMapping(path = "retirive/beneficiaire/{type}")
    public Set<Beneficiaire> getBeneficiareBytypeContrat(@PathVariable("type")TypeContrat type){
        return examenServiceImp.getBeneficairesByType(type);
    }

    @GetMapping(path = "montant/{cinbf}")
    public float retriveMontantBycontratEtBnefeficiare(@PathVariable("cinbf")Integer cinbf){
        return examenServiceImp.getMontantBf(cinbf);
    }
}
