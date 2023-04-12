package com.example.applicationforfixingwashingmachines.service;

import com.example.applicationforfixingwashingmachines.exception.WashingMachineException;
import com.example.applicationforfixingwashingmachines.pojo.WashingMachinePojo;

import java.util.List;

public interface WashingMachineService {

    WashingMachinePojo save(WashingMachinePojo washingMachinePojo);

    boolean deleteById(long id);

    long count();

    List<WashingMachinePojo> findAll();

    WashingMachinePojo getById(Long id) throws WashingMachineException;

    void endOfAuction();
}
