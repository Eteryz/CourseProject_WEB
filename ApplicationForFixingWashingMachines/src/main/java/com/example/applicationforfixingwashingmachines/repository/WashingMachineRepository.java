package com.example.applicationforfixingwashingmachines.repository;

import com.example.applicationforfixingwashingmachines.entity.WashingMachine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface WashingMachineRepository extends JpaRepository<WashingMachine, Long> {

    List<WashingMachine> findAllByEstimatedDateLessThanEqual(LocalDateTime estimatedDate);

    List<WashingMachine> findAllByFinishDateLessThanEqual(LocalDateTime estimatedDate);
}
