package com.medicale.clinique.Controller;

import com.medicale.clinique.Entities.Bus;
import com.medicale.clinique.Entities.Trajet;
import com.medicale.clinique.Entities.Utlisateur;
import com.medicale.clinique.Services.IExamenServicesImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/examen")
public class ExamenController {
    private final IExamenServicesImp examenServicesImp;

@PostMapping(path = "add/trajet")
    public Trajet ajouterTrajet(@RequestBody Trajet trajet){
    return examenServicesImp.ajouterTrajet(trajet);
}

@PostMapping(path = "add/etudiant")
    public Utlisateur ajouterEtudiant(@RequestBody Utlisateur etudiant){
    return examenServicesImp.ajouterEtudiant(etudiant);
}

@PostMapping(path = "add/bus")
    public Bus addBusChauffeur(@RequestBody  Bus bus){
    return examenServicesImp.ajouterBusEtChauffeur(bus);
}
@PutMapping(path = "affecter_bus_trajet/{idbus}/{idTrajet}")
    public Bus affectation(@PathVariable("idbus") int idbus,@PathVariable("idTrajet")int idTrajet){
    return examenServicesImp.AffecterTrajetABus(idbus,idTrajet);
}

@PostMapping ("affeterEtudiant/{nom}/{prenom}/{imatricuatio}")
    public String affecterEtudiant(@PathVariable("nom")String nom,@PathVariable("prenom")String prnom,@PathVariable("imatricuatio")String imatricuatio){
    return examenServicesImp.affecterEtudiantABus(nom,prnom,imatricuatio);
}
}
