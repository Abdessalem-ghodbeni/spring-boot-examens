package com.example.abdessalem_examen.Repository;

import com.example.abdessalem_examen.Entites.Reservation;
import com.example.abdessalem_examen.Entites.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("select reservation FROM Reservation reservation where reservation.status=")
    List<Reservation>listerTReservation();
}