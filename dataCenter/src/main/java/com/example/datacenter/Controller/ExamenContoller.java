package com.example.datacenter.Controller;

import com.example.datacenter.Entities.DataCenter;
import com.example.datacenter.Entities.Utlisateur;
import com.example.datacenter.Entities.VirtualMachine;
import com.example.datacenter.Services.IExamenServicesImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/examen")
public class ExamenContoller {
    private final IExamenServicesImp examenServicesImp;

    @PostMapping(path = "add/user")
    public void addUser(@RequestBody Utlisateur utlisateur){
        examenServicesImp.ajouterUtilisateur(utlisateur);
    }
@PutMapping(path = "affecterVmUser/{idvm}/{iduser}")
public void affecterVmUser(@PathVariable("idvm")int idvm,@PathVariable("iduser")int iduser){
        examenServicesImp.affecterVmUser(idvm,iduser);
}
    @PostMapping(path = "add/dataCenter")
    public void addDataCenter(@RequestBody DataCenter dc){
        examenServicesImp.ajouterDc(dc);
    }
@PostMapping(path = "add/vm")
    public int ajouterVm(@RequestBody VirtualMachine vm){
        return examenServicesImp.ajouterVm(vm);
}
@PutMapping(path = "activer/mv/{idvm}")
    public void activation(@PathVariable("idvm")int idvm){
        examenServicesImp.demarrerInstanceUser(idvm);
    }
    @PutMapping(path = "desactiver/mv/{idvm}")
    public void desactiver(@PathVariable("idvm")int idvm){
        examenServicesImp.arreterInstanceUser(idvm);
    }

@GetMapping(path = "get/datacenter/{date}")
    public List<DataCenter> getAll(@PathVariable("date")Date date){
        return examenServicesImp.listerDatacenter(date);
}

@PutMapping(path = "affecterVm/datacenter/{idVm}")
    public void affecterVm(@PathVariable("idVm")int idVm){
        examenServicesImp.affecterVm(idVm);
}
}
