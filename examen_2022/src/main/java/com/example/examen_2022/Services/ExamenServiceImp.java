package com.example.examen_2022.Services;

import com.example.examen_2022.Entities.Assurance;
import com.example.examen_2022.Entities.Beneficiaire;
import com.example.examen_2022.Entities.Contrat;
import com.example.examen_2022.Entities.TypeContrat;
import com.example.examen_2022.Repository.IAssuranceRepository;
import com.example.examen_2022.Repository.IBeneficiareRepository;
import com.example.examen_2022.Repository.IContratRepository;
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
public class ExamenServiceImp implements IExamenService {

    private final IBeneficiareRepository beneficiareRepository;
    private final IContratRepository contratRepository;
    private final IAssuranceRepository assuranceRepository;

    @Override
    public Beneficiaire ajouterBeneficiaire(Beneficiaire bf) {
        return beneficiareRepository.save(bf);
    }

    @Override
    public Contrat ajouterContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Transactional
    @Override
    public Assurance ajouterAssurance(Assurance a, int cinBf, String matricule) {
        Beneficiaire beneficiaire = beneficiareRepository.findByCin(cinBf);
        Contrat contrat = contratRepository.findByMatricule(matricule);
        a.setBeneficiaire(beneficiaire);
        a.setContrat(contrat);
        Assurance assurance = assuranceRepository.save(a);


        return assurance;
    }

    @Override
    public Contrat getContratBf(int idBf) {
        Beneficiaire beneficiaire = beneficiareRepository.findById(idBf).orElseThrow(null);
//initialiser le contrat avec le premier contrat de la liste **get(0) ne peut pas etre appliqué que sur une liste et non pas set
        Contrat contrat = beneficiaire.getAssurances().get(0).getContrat();


        LocalDate oldDate = contrat.getDateEffet();
        for (int i = 1; i < beneficiaire.getAssurances().size(); i++) {
            //donner l'assurance a un indice i
            Assurance assurance = beneficiaire.getAssurances().get(i);
            if (oldDate.isAfter(assurance.getContrat().getDateEffet())) {
                contrat = assurance.getContrat();
                return contrat;


            }
        }
        return null;

    }

    @Override
    public Set<Beneficiaire> getBeneficairesByType(TypeContrat typeContrat) {

        return beneficiareRepository.getByAssuranceType(typeContrat);


    }

    @Override
    public float getMontantBf(int cinBf) {
        Beneficiaire beneficiaire = beneficiareRepository.findByCin(cinBf);
        float MontantAssurance = 0;
        for (Assurance assurance : beneficiaire.getAssurances()) {
            if (assurance.getContrat().getType() == TypeContrat.Annuel) {
                MontantAssurance += assurance.getMontant();

            } else if (assurance.getContrat().getType() == TypeContrat.Mensuel) {
                MontantAssurance += assurance.getMontant() * 12;
            } else {
                MontantAssurance += assurance.getMontant() * 2;
            }
        }
        return MontantAssurance;

    }

    @Override
    @Scheduled(cron = "*/60 * * * * *")
    public void statistiques() {
        TreeMap<Integer, Integer> myStat = new TreeMap<>(Collections.reverseOrder());
        List<Beneficiaire> beneficiaires = beneficiareRepository.findAll();
        for (Beneficiaire beneficiaire : beneficiaires) {
            myStat.put(beneficiaire.getAssurances().size(), beneficiaire.getCin());

        }
        for (Map.Entry<Integer, Integer> entry : myStat.entrySet()) {
            log.info(entry.getKey() + "|" + entry.getValue());
        }
    }
}
