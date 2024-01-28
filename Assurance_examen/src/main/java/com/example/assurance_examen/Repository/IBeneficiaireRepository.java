package com.example.assurance_examen.Repository;

import com.example.assurance_examen.Entities.Beneficiare;
import com.example.assurance_examen.Entities.TypeContrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface IBeneficiaireRepository extends JpaRepository<Beneficiare,Integer> {
    Beneficiare findBeneficiareByCin(int cinBf);
    @Query("select beneficiare from Beneficiare beneficiare join beneficiare.assurances assurance join assurance.contrat contrat where contrat.type=:type")
    Set<Beneficiare> getBeneficairesByType(@Param("type")TypeContrat type);

}
