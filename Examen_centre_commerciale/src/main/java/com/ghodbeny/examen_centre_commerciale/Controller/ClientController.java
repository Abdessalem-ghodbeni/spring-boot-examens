package com.ghodbeny.examen_centre_commerciale.Controller;

import com.ghodbeny.examen_centre_commerciale.Entities.Client;
import com.ghodbeny.examen_centre_commerciale.Services.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/client")
public class ClientController {
    private final IClientService clientService;

    @PostMapping(path = "/addClient/affecte/boutiques/{idBoutique}")
    public ResponseEntity<?>addClientAndAffecteBoutiques(@RequestBody Client client, @PathVariable("idBoutique")List<Long>idBoutiques){
        try{
            clientService.ajouterEtAffecterClientBoutiques(client,idBoutiques);
            return new ResponseEntity<>(HttpStatus.CREATED);

        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping(path = "/ClientBy_boutique/{idBoutique}")
//    public ResponseEntity<?>recupererClientsByBoutique(@PathVariable("idBoutique")Long idBoutique){
//        try{
//            Set<Client> clients=clientService.listeClients(idBoutique);
//            return ResponseEntity.ok(clients);
//        }
//        catch (Exception exception){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
//        }
//    }
//@GetMapping("/clients/{id-boutique}")
//public Set<Client> listeClients(@PathVariable("id-boutique")Long idBoutique) {
//    return clientService.listeClients(idBoutique);
//}
}
