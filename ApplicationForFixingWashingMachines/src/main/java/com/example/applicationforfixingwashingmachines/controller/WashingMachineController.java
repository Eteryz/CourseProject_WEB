package com.example.applicationforfixingwashingmachines.controller;

import com.example.applicationforfixingwashingmachines.exception.WashingMachineException;
import com.example.applicationforfixingwashingmachines.pojo.WashingMachinePojo;
import com.example.applicationforfixingwashingmachines.service.WashingMachineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
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

    @GetMapping("/{id}")
    public WashingMachinePojo getById(@PathVariable Long id)  {
        try {
            return washingMachineService.getById(id);
        } catch (WashingMachineException e) {
            return null;
        }
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
