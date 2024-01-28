package com.example.assurance_examen.Services;

import com.example.assurance_examen.Entities.Assurance;
import com.example.assurance_examen.Entities.Beneficiare;
import com.example.assurance_examen.Entities.Contrat;
import com.example.assurance_examen.Entities.TypeContrat;
import com.example.assurance_examen.Repository.IAssuranceRepository;
import com.example.assurance_examen.Repository.IBeneficiaireRepository;
import com.example.assurance_examen.Repository.IContratRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class IExamenServiceImp implements IExamenServices {
    private final IAssuranceRepository assuranceRepository;
    private final IContratRepository contratRepository;
    private final IBeneficiaireRepository beneficiaireRepository;


    @Override
    public Beneficiare ajouterBeneficiaire(Beneficiare bf) {
        return beneficiaireRepository.save(bf);
    }

    @Override
    public Contrat ajouterContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    @Transactional
    public Assurance ajouterAssurance(Assurance a, int cinBf, String matricule) {
        Contrat contrat = contratRepository.findContratByMatricule(matricule);
        Beneficiare beneficiare = beneficiaireRepository.findBeneficiareByCin(cinBf);
        a.setContrat(contrat);
        a.setBeneficiare(beneficiare);
        return assuranceRepository.save(a);


    }

    @Override
    public Contrat getContratBf(int idBf) {
        Beneficiare beneficiare = beneficiaireRepository.findById(idBf).orElse(null);
        List<Assurance> assurances = new ArrayList<>();
        for (Assurance assurance : beneficiare.getAssurances()) {
            assurances.add(assurance);
        }
        Contrat contrat = assurances.get(0).getContrat();
        LocalDate ancienneDate = contrat.getDateNaissance();
        for (Assurance assurance : assurances) {
            if (ancienneDate.isAfter(assurance.getContrat().getDateNaissance())) {
                contrat = assurance.getContrat();
            }
        }

        return contrat;

    }

    @Override
    public Set<Beneficiare> getBeneficairesByType(TypeContrat typeContrat) {
       return beneficiaireRepository.getBeneficairesByType(typeContrat);
    }

    @Override
    public float getMontantBf(int cinBf) {
       Beneficiare beneficiare=beneficiaireRepository.findBeneficiareByCin(cinBf);
float montant_assurance=0;
for (Assurance assurance :beneficiare.getAssurances()){
    if (assurance.getContrat().getType()==TypeContrat.Semestriel){
        montant_assurance+=assurance.getMontant()*2;
    } else if (assurance.getContrat().getType()==TypeContrat.Mensuel) {
        montant_assurance+=assurance.getMontant()*12;

    }else {
        montant_assurance+=assurance.getMontant();
    }
}
        return montant_assurance;
    }


    @Override
    @Scheduled(cron = "*/60 * * * * *")
    public void statistiques() {

        TreeMap<Integer, Integer> myStat = new TreeMap<>(Collections.reverseOrder());

        for (Beneficiare b : beneficiaireRepository.findAll()) {
            myStat.put(b.getAssurances().size(), b.getCin());
        }
        for (Map.Entry<Integer, Integer> va : myStat.entrySet()) {
            log.info(va.getKey() + "|" + va.getValue());
        }
    }
}
