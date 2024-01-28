package com.example.centrecommerciale.ExamenController;

import com.example.centrecommerciale.Entities.Boutique;
import com.example.centrecommerciale.Entities.Categorie;
import com.example.centrecommerciale.Entities.CentreCommerciale;
import com.example.centrecommerciale.Entities.Client;
import com.example.centrecommerciale.ExamenServices.IExamenServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/examen")
public class ExamenController {
private final IExamenServiceImp examenServiceImp;
    @PostMapping(path = "/add/centre")
public void addCentre(@RequestBody CentreCommerciale centre){
    examenServiceImp.ajoutCentre(centre);

    }

         @PostMapping(path = "/add/affecte_boutique/{idCentre}")
    public void addAndAffecteBoutiques (@RequestBody List<Boutique> boutiques, @PathVariable("idCentre")Long idCentre){
        examenServiceImp.ajouterEtAffecterlisteBoutiques(boutiques,idCentre);
         }

@PostMapping(path = "add/client_boutique/{boutiques}")
    public void add_clients_boutiques(@RequestBody Client client,@PathVariable("boutiques")List<Long> idBoutiques){
        examenServiceImp.ajouterEtAffecterClientBoutiques(client,idBoutiques);
}


@GetMapping(path = "getClient/by/boutique/{id_boutique}")
    public List<Client> getAllClient(@PathVariable("id_boutique")Long id_boutique){
        return examenServiceImp.listeClients(id_boutique);
}

@GetMapping(path = "get/boutique_centre/{idCentre}")
    public List<Boutique> getBoutiqueByCentre(@PathVariable("idCentre") Long idCentre){
        return examenServiceImp.listeBoutiques(idCentre);
}
@GetMapping(path = "get/client_by_categorie/{categorie}")
    public List<Client>getClientByCategorie(@PathVariable("categorie")Categorie categorie){
        return examenServiceImp.listeDeClientsParCategorie(categorie);
}
}
