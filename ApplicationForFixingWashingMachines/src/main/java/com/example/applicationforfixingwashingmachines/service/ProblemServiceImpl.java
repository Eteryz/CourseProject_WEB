package com.example.applicationforfixingwashingmachines.service;

import com.example.applicationforfixingwashingmachines.entity.Problem;
import com.example.applicationforfixingwashingmachines.entity.WashingMachine;
import com.example.applicationforfixingwashingmachines.pojo.ProblemPojo;
import com.example.applicationforfixingwashingmachines.repository.ProblemRepository;
import com.example.applicationforfixingwashingmachines.repository.WashingMachineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProblemServiceImpl implements ProblemService {

    private final ProblemRepository problemRepository;

    private final WashingMachineRepository washingMachineRepository;

    @Override
    public ProblemPojo save(ProblemPojo problemPojo){
        Problem problem = problemPojo.toEntity();
        Optional<WashingMachine> washingMachine =washingMachineRepository.findById(problemPojo.getWashingMachineId());
        if(washingMachine.isEmpty())
            return null;
        problem.setWashingMachine(washingMachine.get());
        return ProblemPojo.fromEntity(problemRepository.save(problem));
    }

    @Override
    public boolean deleteById(long id) {
        if (problemRepository.existsById(id)) {
            problemRepository.deleteById(id);
            return true;
        } else
            return false;
    }

    @Override
    public long count() {
        return problemRepository.count();
    }

    @Override
    public List<ProblemPojo> findAll(){
        return problemRepository.findAll()
                .stream()
                .map(ProblemPojo::fromEntity)
                .toList();
    }
}
