package com.example.examen_transaction.Services;

import com.example.examen_transaction.Entities.Bank;
import com.example.examen_transaction.Entities.Compte;
import com.example.examen_transaction.Entities.Transaction;

public interface IExamenService {

    public Bank ajouterBank(Bank bank);
    public Compte ajouterCompteEtAffecterAAgence(Compte compte,String agenceBank);
    public String ajouterVirement(Transaction transaction);
    public String ajouterRetrait(Transaction transaction);

    public void getAllTransactionByDate();

}
