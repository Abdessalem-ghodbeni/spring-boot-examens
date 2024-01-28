package com.transport.transport.Controller;

import com.transport.transport.Entites.Bus;
import com.transport.transport.Entites.Trajet;
import com.transport.transport.Entites.Utilisateur;
import com.transport.transport.Services.IservicesImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequiredArgsConstructor
@RequestMapping(path = "/trasport")
public class Controller {
private final IservicesImp servicesImp;
    @PostMapping(path = "/add/trajet")
    public Trajet ajoutertrajert(@RequestBody Trajet trajet){
        return servicesImp.ajouterTrajet(trajet);

    }

    @PostMapping(path = "/add/etudiant")
    public Utilisateur ajouterEtudiant(@RequestBody Utilisateur utilisateur){
        return servicesImp.ajouterEtudiant(utilisateur);

    }

    @PostMapping(path = "/add/bus")
    public Bus ajouterBusEtChaffeur(@RequestBody Bus bus){
        return servicesImp.ajouterBusEtChauffeur(bus);

    }

    @PutMapping(path="/addAndAffecte/{idtrajet}/{idBus}")
    public Bus ajouterFoyerAffectantUniversity(@PathVariable("idBus") Integer idBus , @PathVariable("idBus") Integer idtrajet ){

        return servicesImp.affecterTrajetBus(idBus,idtrajet);

    }
    @PostMapping(path="affecter/{numImma}/{nom}/{prenom}")
    public String affectation(@PathVariable("numImma") String numImma,@PathVariable("nom") String nom,@PathVariable("prenom") String prenom  ){
        return servicesImp.affecterEtudiantBus(numImma,nom,prenom);
    }
}
