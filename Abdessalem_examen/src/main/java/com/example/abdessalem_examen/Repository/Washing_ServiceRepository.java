package com.example.abdessalem_examen.Repository;

import com.example.abdessalem_examen.Entites.Type;
import com.example.abdessalem_examen.Entites.Washing_Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Washing_ServiceRepository extends JpaRepository<Washing_Service, Long> {
    @Query("select washing_service from Washing_Service washing_service where washing_service.type=:type")
    List<Washing_Service>getWahsingServiceByService(@Param("type")Type type);

}