package com.example.examen_transaction.Services;

import com.example.examen_transaction.Entities.*;
import com.example.examen_transaction.Repository.BankRepository;
import com.example.examen_transaction.Repository.CompteRepository;
import com.example.examen_transaction.Repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class IExamenServiceImpl implements IExamenService {

    private final BankRepository bankRepository;
    private final CompteRepository compteRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public Bank ajouterBank(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    @Transactional
    public Compte ajouterCompteEtAffecterAAgence(Compte compte, String agenceBank) {
        Bank bank = bankRepository.findByAgence(agenceBank);
        bank.getComptes().add(compte);
        return compteRepository.save(compte);


    }

    @Override
    @Transactional
    public String ajouterVirement(Transaction transaction) {
        String message = "";
        if (transaction.getType() == TypeTransactions.VIREMENT && transaction.getCompteExpediteur().getType() == TypeCompte.EPARGNE) {
            message = "On ne peut pas faire un virement à partir d’un compte épargne";


        } else if (transaction.getType() == TypeTransactions.VIREMENT && transaction.getCompteExpediteur().getType() != TypeCompte.EPARGNE
                && transaction.getCompteExpediteur().getSolde() < transaction.getMontant() + 3) {
            message = "On ne peut pas faire un virement : Solde " + transaction.getCompteExpediteur().getSolde() + "insuffisant";

        } else {
            message = "VIREMENT de" + transaction.getMontant() + "DT de compte " + transaction.getCompteExpediteur().getIdCompte() + " vers le compte " + transaction.getCompteDestinataire().getIdCompte() + " approuvé avec succès.";
            transaction.getCompteExpediteur().setSolde(transaction.getCompteExpediteur().getSolde() - (transaction.getMontant() + 3));
            transaction.getCompteDestinataire().setSolde(transaction.getCompteDestinataire().getSolde() + transaction.getMontant());
            transaction.setDateTrasaction(LocalDate.now());


        }
        transactionRepository.save(transaction);
        return message;
    }

    @Override
    public String ajouterRetrait(Transaction transaction) {
        String message = "";
        Compte compteExpediteur = compteRepository.findById(transaction.getCompteExpediteur().getIdCompte()).orElse(null);

        if (transaction.getType() == TypeTransactions.RETRAIT && compteExpediteur.getSolde() < transaction.getMontant() + 2) {
            message = " On ne peut pas faire un retrait : Solde insuffisant";
        } else {
            message = "RETRAIT de " + transaction.getMontant() + "DT de compte" + compteExpediteur.getIdCompte() + "approuvé avec succès";
            compteExpediteur.setSolde(compteExpediteur.getSolde() - (transaction.getMontant() + 2));
            transaction.setDateTrasaction(LocalDate.now());
        }
        transactionRepository.save(transaction);
        return message;

    }
    @Scheduled(cron = "*/30 * * * * *")
    @Override
    public void getAllTransactionByDate() {
        log.info("liste des transaction is ");
        List<Transaction> list=transactionRepository.findByDateTrasaction(LocalDate.of(2023,01,04));
        for(Transaction transaction :list){
            log.info(String.valueOf(transaction.getIdTransaction()));
        }
    }
}
