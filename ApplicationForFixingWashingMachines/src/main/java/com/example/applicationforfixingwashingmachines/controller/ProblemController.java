package com.example.applicationforfixingwashingmachines.controller;

import com.example.applicationforfixingwashingmachines.exception.ProblemNotFound;
import com.example.applicationforfixingwashingmachines.pojo.ProblemPojo;
import com.example.applicationforfixingwashingmachines.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequiredArgsConstructor
@RequestMapping("/api/v1/problem")
public class ProblemController {

    private final ProblemService problemService;

    @PostMapping("/add")
    public ProblemPojo addWashingMachine(@RequestBody ProblemPojo problemPojo){
        return problemService.save(problemPojo);
    }

    @GetMapping("/{id}")
    public ProblemPojo getById(@PathVariable Long id){
        try {
            return problemService.findById(id);
        } catch (ProblemNotFound e) {
            return null;
        }
    }

    @GetMapping()
    public List<ProblemPojo> getAll(){
        return problemService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return problemService.deleteById(id);
    }

    @GetMapping("/count")
    public long count(){
        return problemService.count();
    }
}
