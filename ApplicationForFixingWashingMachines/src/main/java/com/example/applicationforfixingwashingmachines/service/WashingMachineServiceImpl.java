package com.example.applicationforfixingwashingmachines.service;

import com.example.applicationforfixingwashingmachines.entity.WashingMachine;
import com.example.applicationforfixingwashingmachines.exception.WashingMachineException;
import com.example.applicationforfixingwashingmachines.pojo.WashingMachinePojo;
import com.example.applicationforfixingwashingmachines.repository.WashingMachineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WashingMachineServiceImpl implements WashingMachineService{

    private final WashingMachineRepository washingMachineRepository;

    @Override
    public WashingMachinePojo save(WashingMachinePojo washingMachinePojo){
        WashingMachine washingMachine = washingMachinePojo.toEntity();
        return WashingMachinePojo.fromEntity(washingMachineRepository.save(washingMachine));
    }

    @Override
    public boolean deleteById(long id) {
        if (washingMachineRepository.existsById(id)) {
            washingMachineRepository.deleteById(id);
            return true;
        } else
            return false;
    }


    @Override
    public long count() {
        return washingMachineRepository.count();
    }

    @Override
    public List<WashingMachinePojo> findAll(){
        return washingMachineRepository.findAll()
                .stream()
                .map(WashingMachinePojo::fromEntity)
                .toList();
    }

    @Override
    public WashingMachinePojo getById(Long id) throws WashingMachineException {
        return WashingMachinePojo.fromEntity(washingMachineRepository.findById(id).orElseThrow(
                () -> new WashingMachineException("WashingMachine with id: "+id+ " not found!")
        ));
    }

    @Override
    public void endOfAuction() {

    }

}
