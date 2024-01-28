package com.medicale.clinique.Repository;

import com.medicale.clinique.Entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBusRepository extends JpaRepository<Bus,Integer> {
    Bus findByImmatriculation(String immatriculation);
}
