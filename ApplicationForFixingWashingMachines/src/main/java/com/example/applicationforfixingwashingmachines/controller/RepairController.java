package com.example.applicationforfixingwashingmachines.controller;

import com.example.applicationforfixingwashingmachines.pojo.RepairPojo;
import com.example.applicationforfixingwashingmachines.service.RepairService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequiredArgsConstructor
@RequestMapping("/api/v1/repair")
public class RepairController {

    private final RepairService repairService;

    @PostMapping("/add")
    public RepairPojo addWashingMachine(@RequestBody RepairPojo repairPojo){
        return repairService.save(repairPojo);
    }

    @GetMapping()

    public List<RepairPojo> getAll(){
        return repairService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return repairService.deleteById(id);
    }

    @GetMapping("/count")
    public long count(){
        return repairService.count();
    }

}
