package com.example.applicationforfixingwashingmachines.service;

import com.example.applicationforfixingwashingmachines.pojo.RepairPojo;

import java.util.List;

public interface RepairService {
    RepairPojo save(RepairPojo repairPojo);

    boolean deleteById(long id);

    long count();

    List<RepairPojo> findAll();
}
