package com.example.assurance_examen.Repository;

import com.example.assurance_examen.Entities.Assurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAssuranceRepository extends JpaRepository<Assurance,Integer> {


}
