package com.example.applicationforfixingwashingmachines.service;

import com.example.applicationforfixingwashingmachines.entity.Problem;
import com.example.applicationforfixingwashingmachines.entity.Repair;
import com.example.applicationforfixingwashingmachines.pojo.RepairPojo;
import com.example.applicationforfixingwashingmachines.repository.ProblemRepository;
import com.example.applicationforfixingwashingmachines.repository.RepairRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RepairServiceImpl implements RepairService{

    private final RepairRepository repairRepository;

    private final ProblemRepository problemRepository;

    @Override
    public RepairPojo save( RepairPojo repairPojo){
        Repair repair = repairPojo.toEntity();
        Optional<Problem> problem = problemRepository.findById(repairPojo.getProblemId());
        if(problem.isEmpty())
            return null;
        repair.setProblem(problem.get());
        return RepairPojo.fromEntity(repairRepository.save(repair));
    }


    @Override
    public boolean deleteById(long id) {
        if (repairRepository.existsById(id)) {
            repairRepository.deleteById(id);
            return true;
        } else
            return false;
    }

    @Override
    public long count() {
        return repairRepository.count();
    }

    @Override
    public List<RepairPojo> findAll(){
        return repairRepository.findAll()
                .stream()
                .map(RepairPojo::fromEntity)
                .toList();
    }

}
