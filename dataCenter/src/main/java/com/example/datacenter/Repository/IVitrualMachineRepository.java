package com.example.datacenter.Repository;

import com.example.datacenter.Entities.VirtualMachine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVitrualMachineRepository extends JpaRepository<VirtualMachine,Integer> {
}
