package com.example.applicationforfixingwashingmachines.repository;

import com.example.applicationforfixingwashingmachines.entity.WashingMachine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WashingMachineRepository extends JpaRepository<WashingMachine, Long> {
}
