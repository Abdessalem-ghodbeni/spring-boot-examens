package com.example.abdessalem_examen.Services;

import com.example.abdessalem_examen.Entites.Type;
import com.example.abdessalem_examen.Entites.Vehicle;
import com.example.abdessalem_examen.Entites.Washing_Service;
import com.example.abdessalem_examen.Entites.Worker;
import org.hibernate.jdbc.Work;

import java.util.List;
import java.util.Map;

public interface IExamenService {
    public Worker addWorker(Worker worker);
    public  void addWashingService(List<Washing_Service> washingService);

    public Vehicle addVehicleReservationAndAffectToWashingservice(Vehicle vehicle,List<Long>idService);

    public Worker affectWorkerToReservation(String nic,List<Long>idReservation);
    public Float calculateTotaleIncomePerWorker(String name, Type typeService);

    public void getReservation();

    public Map<String,Long>getListServiceAndNbreservation();
}
