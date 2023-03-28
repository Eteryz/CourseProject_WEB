package com.example.applicationforfixingwashingmachines.repository;

import com.example.applicationforfixingwashingmachines.entity.Repair;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairRepository extends JpaRepository<Repair, Long> {
}
