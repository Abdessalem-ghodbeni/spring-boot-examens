package com.example.abdessalem_examen.Repository;

import com.example.abdessalem_examen.Entites.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
    Worker findByNic(String nic);
    Worker findByName(String name);
}