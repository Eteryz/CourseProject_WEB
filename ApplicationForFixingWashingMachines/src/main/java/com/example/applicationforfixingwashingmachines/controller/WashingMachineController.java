package com.example.applicationforfixingwashingmachines.controller;

import com.example.applicationforfixingwashingmachines.pojo.WashingMachinePojo;
import com.example.applicationforfixingwashingmachines.service.WashingMachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/washingMachine")
@RequiredArgsConstructor
public class WashingMachineController {

    private final WashingMachineService washingMachineService;

    @PostMapping("/add")
    public WashingMachinePojo addWashingMachine(@RequestBody WashingMachinePojo washingMachinePojo){
        return washingMachineService.save(washingMachinePojo);
    }

    @GetMapping()
    public List<WashingMachinePojo> getAll(){
        return washingMachineService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return washingMachineService.deleteById(id);
    }

    @GetMapping("/count")
    public long count(){
        return washingMachineService.count();
    }
}
