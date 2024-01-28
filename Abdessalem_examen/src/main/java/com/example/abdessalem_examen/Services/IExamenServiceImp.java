package com.example.abdessalem_examen.Services;

import com.example.abdessalem_examen.Entites.*;
import com.example.abdessalem_examen.Repository.ReservationRepository;
import com.example.abdessalem_examen.Repository.VehicleRepository;
import com.example.abdessalem_examen.Repository.Washing_ServiceRepository;
import com.example.abdessalem_examen.Repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class IExamenServiceImp implements IExamenService {
    private final ReservationRepository reservationRepository;
    private final VehicleRepository vehicleRepository;
    private final Washing_ServiceRepository washingServiceRepository;
    private  final WorkerRepository workerRepository;

    @Override
    public Worker addWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public void addWashingService(List<Washing_Service> washingService) {
        List<Washing_Service> washingServices = washingService.stream().map(washingServicee -> washingServiceRepository.save(washingServicee)).collect(Collectors.toList());

    }

    @Override
    @Transactional
    public Vehicle addVehicleReservationAndAffectToWashingservice(Vehicle vehicle, List<Long> idService) {

        Reservation reservation = new Reservation();


        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
//        reservation.setTimereservation(timestamp);


        Set<Washing_Service> washingServices = new HashSet<>();
        for (Long serviceId : idService) {
            Washing_Service washingService = washingServiceRepository.findById(serviceId).orElse(null);
            if (washingService != null) {
                washingServices.add(washingService);
            }
        }
        reservation.setWashing_services(washingServices);


        reservation.setStatus(Status.PENDING);


        Set<Reservation> reservations = vehicle.getReservations();
        if (reservations == null) {
            reservations = new HashSet<>();
            vehicle.setReservations(reservations);
        }
        reservations.add(reservation);


        vehicleRepository.save(vehicle);

        return vehicle;

    }

    @Override
    @Transactional
    public Worker affectWorkerToReservation(String nic, List<Long> idReservation) {
       Worker worker=workerRepository.findByNic(nic);
        List<Reservation>reservationList=new ArrayList<>();
        for (Long idreservation:idReservation){
            Reservation reservation=reservationRepository.findById(idreservation).orElse(null);
            reservationList.add(reservation);

        }
        for (Reservation reservation:reservationList){
            if(worker.getReservations().size()<=5){
                worker.getReservations().add(reservation);
                reservation.setStatus(Status.CONFIRMED);
                reservationRepository.save(reservation);
            }


        }

        workerRepository.save(worker);
        return worker;
    }

    @Override
    public Float calculateTotaleIncomePerWorker(String name, Type typeService) {

        Worker worker = workerRepository.findByName(name);
        Set<Reservation> reservationList = worker.getReservations();

        float totalIncome = 0.0f;

        for (Reservation reservation : reservationList) {
            if (reservation.getStatus() == Status.CONFIRMED) {
                Set<Washing_Service> washingServices = reservation.getWashing_services();
                for (Washing_Service washingService : washingServices) {
                    if (washingService.getType() == typeService) {
                        totalIncome += washingService.getPrice();
                    }
                }
            }
        }

        return totalIncome;

    }

    @Scheduled(cron = "*/15 * * * * *")
    @Override
    public void getReservation() {
List<Reservation> reservations=reservationRepository.listerTReservation();
for (Reservation reservation:reservations){
    log.info(String.valueOf(reservation.getStatus()));
}
    }

    @Override
    public Map<String, Long> getListServiceAndNbreservation() {
        Map<String, Long> serviceAndReservationCount = new HashMap<>();

        List<Washing_Service> washingServices = washingServiceRepository.findAll();

        for (Washing_Service washingService : washingServices) {
            Set<Reservation> reservations = washingService.getReservations();
            long reservationCount = 0;

            for (Reservation reservation : reservations) {
                if (reservation.getStatus() == Status.CONFIRMED) {
                    reservationCount++;
                }
            }

            String serviceKey = washingService.getType().toString() + ": " + washingService.getIdService();
            serviceAndReservationCount.put(serviceKey, reservationCount);
        }

        return serviceAndReservationCount;
    }


}
