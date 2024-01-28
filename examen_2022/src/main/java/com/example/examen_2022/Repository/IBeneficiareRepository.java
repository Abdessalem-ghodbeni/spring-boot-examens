package com.example.examen_2022.Repository;

import com.example.examen_2022.Entities.Beneficiaire;
import com.example.examen_2022.Entities.Contrat;
import com.example.examen_2022.Entities.TypeContrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface IBeneficiareRepository extends JpaRepository<Beneficiaire,Integer> {
    Beneficiaire findByCin(Integer cin);
    @Query("select beneficiaire from Beneficiaire beneficiaire join beneficiaire.assurances assurance join assurance.contrat contrat where contrat.type=:ts")
    Set<Beneficiaire> getByAssuranceType(@Param("ts") TypeContrat ts);



}
