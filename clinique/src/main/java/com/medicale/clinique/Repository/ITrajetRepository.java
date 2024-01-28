package com.medicale.clinique.Repository;

import com.medicale.clinique.Entities.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITrajetRepository extends JpaRepository<Trajet,Integer> {
}
