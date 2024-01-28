package com.example.datacenter.Services;

import com.example.datacenter.Entities.DataCenter;
import com.example.datacenter.Entities.Utlisateur;
import com.example.datacenter.Entities.VirtualMachine;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IExamenServices {

    public void ajouterUtilisateur(Utlisateur u);
    public void ajouterDc(DataCenter dataCenter);
    public int ajouterVm(VirtualMachine virtualMachine);
    public void affecterVmUser(int vm,int iduser );

    public void affecterVm(int idvm);
    public void demarrerInstanceUser(int idvm);
    public void arreterInstanceUser(int idvm);
    public List<DataCenter> listerDatacenter(Date dateFabrication);
    public void getCenter(Date date);
}
