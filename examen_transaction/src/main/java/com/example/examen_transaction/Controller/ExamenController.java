package com.example.examen_transaction.Controller;

import com.example.examen_transaction.Entities.Bank;
import com.example.examen_transaction.Entities.Compte;
import com.example.examen_transaction.Entities.Transaction;
import com.example.examen_transaction.Services.IExamenServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/examen")
public class ExamenController {
private final IExamenServiceImpl examenService;

@PostMapping(path = "add/bank")
    public Bank addBank(@RequestBody Bank bank){
    return examenService.ajouterBank(bank);
}

@PostMapping(path = "add/compte_agence/{agence}")
    public Compte ajouterEtAffecterCompte(@RequestBody Compte compte, @PathVariable("agence") String agence){
    return examenService.ajouterCompteEtAffecterAAgence(compte,agence);
}

@PostMapping(path = "add/transaction")
    public String addTransaction(@RequestBody Transaction transaction){
    return examenService.ajouterVirement(transaction);
}
@PostMapping(path = "add/retrait")
    public String addRetrait(@RequestBody Transaction transaction){
    return examenService.ajouterRetrait(transaction);
}
}
