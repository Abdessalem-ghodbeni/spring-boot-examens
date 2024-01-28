package com.example.datacenter.Services;

import com.example.datacenter.Entities.DataCenter;
import com.example.datacenter.Entities.Etat;
import com.example.datacenter.Entities.Utlisateur;
import com.example.datacenter.Entities.VirtualMachine;
import com.example.datacenter.Repository.IDataCenterRepository;
import com.example.datacenter.Repository.IUtilisateurRepository;
import com.example.datacenter.Repository.IVitrualMachineRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class IExamenServicesImp implements IExamenServices {
    private final IDataCenterRepository dataCenterRepository;
    private final IUtilisateurRepository utilisateurRepository;
    private final IVitrualMachineRepository vitrualMachineRepository;

    @Override
    public void ajouterUtilisateur(Utlisateur u) {
        utilisateurRepository.save(u);
    }

    @Override
    public void ajouterDc(DataCenter dataCenter) {
        dataCenterRepository.save(dataCenter);
    }

    @Override
    public int ajouterVm(VirtualMachine virtualMachine) {
        VirtualMachine virtualMachineNew = vitrualMachineRepository.save(virtualMachine);
        return virtualMachineNew.getIdVm();
    }

    @Override
    @Transactional
    public void affecterVmUser(int vm, int iduser) {
        VirtualMachine virtualMachine = vitrualMachineRepository.findById(vm).orElse(null);
        Utlisateur user = utilisateurRepository.findById(iduser).orElse(null);

            user.getVirtualMachines().add(virtualMachine);
            utilisateurRepository.save(user);

    }

    @Override
    @Transactional
    public void affecterVm(int idvm) {
        VirtualMachine virtualMachine = vitrualMachineRepository.findById(idvm).orElse(null);
        List<DataCenter> dataCenterList = dataCenterRepository.findAll();
        for (DataCenter dataCenter : dataCenterList) {
            if (dataCenter.getEspaceLibreDisque() > virtualMachine.getTailleDisque()) {
                int newEspaceLibreDisque = dataCenter.getEspaceLibreDisque() - virtualMachine.getTailleDisque();
                dataCenter.setEspaceLibreDisque(newEspaceLibreDisque);
                virtualMachine.setDataCenter(dataCenter);
                vitrualMachineRepository.save(virtualMachine);
            }

        }


    }

    @Override
    public void demarrerInstanceUser(int idvm) {
        VirtualMachine virtualMachineAli = vitrualMachineRepository.findById(idvm).orElse(null);


        if (virtualMachineAli.getEtat() == Etat.STTOPED) {
            virtualMachineAli.setEtat(Etat.RUNNING);
            vitrualMachineRepository.save(virtualMachineAli);
        }
    }

    @Override
    public void arreterInstanceUser(int idvm) {
        VirtualMachine virtualMachineAli = vitrualMachineRepository.findById(idvm).orElse(null);


        if (virtualMachineAli.getEtat() == Etat.RUNNING) {
            virtualMachineAli.setEtat(Etat.STTOPED);
            vitrualMachineRepository.save(virtualMachineAli);
        }
    }

    @Override
    public List<DataCenter> listerDatacenter(Date dateFabrication) {
        return dataCenterRepository.listerDataCenter(dateFabrication);


    }

    @Override
    public void getCenter(Date date) {
        List<DataCenter> dataCenterList = dataCenterRepository.listerDataCenter(date);
        for (DataCenter dataCenter : dataCenterList) {
            log.info("region is " + dataCenter.getRegion());
            for (VirtualMachine virtualMachine : dataCenter.getVirtualMachines()) {
                log.info("os" + virtualMachine.getOs());
            }
        }
    }


}
