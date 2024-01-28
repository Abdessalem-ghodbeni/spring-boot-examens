package com.example.abdessalem_examen.Controller;

import com.example.abdessalem_examen.Entites.Type;
import com.example.abdessalem_examen.Entites.Vehicle;
import com.example.abdessalem_examen.Entites.Washing_Service;
import com.example.abdessalem_examen.Entites.Worker;
import com.example.abdessalem_examen.Services.IExamenServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/examen")
public class ExamenController {
    private final IExamenServiceImp examenServiceImp;


    @PostMapping(path = "add/worker")
    public Worker addWWorker(@RequestBody Worker worker) {
        return examenServiceImp.addWorker(worker);
    }


    @PostMapping(path = "add/washing_service")
    public void addwashing_service(@RequestBody List<Washing_Service> washingServiceList) {
        examenServiceImp.addWashingService(washingServiceList);
    }

    @PostMapping(path = "add_washing_service/{idService}")
    public Vehicle addVehiculeReservationAndAffectation(@RequestBody Vehicle vehicle, @PathVariable("idService") List<Long> idServices) {
        return examenServiceImp.addVehicleReservationAndAffectToWashingservice(vehicle, idServices);
    }

    @PutMapping(path = "affect/worker/servervaion/{nic}/{idReservations}")
    public Worker affectation(@PathVariable("nic") String nic, @PathVariable("idReservations") List<Long> idReservations) {
        return examenServiceImp.affectWorkerToReservation(nic, idReservations);
    }

    @GetMapping(path = "totle/{name}/{type}")
    public float getSomme(@PathVariable("name")String name, @PathVariable("type")Type type){
        return examenServiceImp.calculateTotaleIncomePerWorker(name,type);
    }
}
