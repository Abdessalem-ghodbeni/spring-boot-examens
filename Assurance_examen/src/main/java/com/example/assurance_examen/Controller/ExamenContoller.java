package com.example.assurance_examen.Controller;

import com.example.assurance_examen.Entities.Assurance;
import com.example.assurance_examen.Entities.Beneficiare;
import com.example.assurance_examen.Entities.Contrat;
import com.example.assurance_examen.Entities.TypeContrat;
import com.example.assurance_examen.Services.IExamenServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/examen")
public class ExamenContoller {
    private final IExamenServiceImp serviceImp;
    @PostMapping(path = "add/beneficiare")
    public Beneficiare addBeneficiare(@RequestBody Beneficiare bf){
        return serviceImp.ajouterBeneficiaire(bf);
    }

    @PostMapping(path = "add/contrat")
    public Contrat ajouterContrat(@RequestBody Contrat c){
        return serviceImp.ajouterContrat(c);
    }

    @PostMapping(path = "add/assurance_benef_contrat/{cinbf}/{matricule}")
    public Assurance addAndAffecteToContratAndBenficiare(@PathVariable("cinbf") int cinbf,@PathVariable("matricule")String matricule,@RequestBody Assurance assurance){
        return serviceImp.ajouterAssurance(assurance, cinbf, matricule);
    }
    @GetMapping(path = "retieve_ancient/contrat/{idBf}")
    public Contrat getAncientContrat(@PathVariable("idBf")int idBf){
        return serviceImp.getContratBf(idBf);
    }

    @GetMapping(path = "get_beneficiare/by_type/{type}")
    public Set<Beneficiare> retrieveBeneficiareByTypeContrat(@PathVariable("type")TypeContrat type){
        return serviceImp.getBeneficairesByType(type);
    }
    @GetMapping(path = "get_montant/{cinBf}")
    public float montantAssurance(@PathVariable("cinBf") int cinBf){
        return serviceImp.getMontantBf(cinBf);
    }

}


