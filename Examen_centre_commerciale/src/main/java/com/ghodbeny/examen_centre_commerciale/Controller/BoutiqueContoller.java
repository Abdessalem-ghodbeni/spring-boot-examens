package com.ghodbeny.examen_centre_commerciale.Controller;

//import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ghodbeny.examen_centre_commerciale.Entities.Boutique;
import com.ghodbeny.examen_centre_commerciale.Entities.Client;
import com.ghodbeny.examen_centre_commerciale.Services.IBoutiqueServices;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/boutiques")
public class BoutiqueContoller {
    private final IBoutiqueServices boutiqueServices;


    @PostMapping(path = "/AjouterBoutique/affecter_centre/{id_centre}")
public void ajouterBoutiqueAndAffectForCentre(@PathVariable("id_centre")long id_centre, @RequestBody List<Boutique> boutiques){
        boutiqueServices.ajouterEtAffecterlisteBoutiques(boutiques, id_centre);
    }
//@PostMapping(path = "/addBoutiqueClient")
//    public void addBoutiqueClient(@RequestBody Client client,@RequestBody List<Long> idBoutiques){
//        boutiqueServices.ajouterEtAffecterClientBoutiques(client, idBoutiques);
//}
//@PostMapping(path = "/addBoutiqueClient")
//public void addBoutiqueClient(@RequestBody Map<String, Object> request) {
//    ObjectMapper objectMapper = new ObjectMapper();
//
//    Client client = objectMapper.convertValue(request.get("client"), Client.class);
//    List<Long> idBoutiques = objectMapper.convertValue(request.get("idBoutiques"), new TypeReference<>() {});
//
//    boutiqueServices.ajouterEtAffecterClientBoutiques(client, idBoutiques);
//}

    @GetMapping(path = "/boutiques/{id}")
    public ResponseEntity<?> listeDesBoutiques(@PathVariable("id")Long id){
        try{
            return ResponseEntity.ok(boutiqueServices.listeBoutiques(id));
        }
        catch (Exception exp){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exp.getMessage());
        }
    }
}
