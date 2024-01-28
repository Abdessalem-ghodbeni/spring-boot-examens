package com.transport.transport.Repository;

import com.transport.transport.Entites.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBusRepositort extends JpaRepository<Bus,Integer> {
    Bus findByNumImmatriculation(String num);
}
