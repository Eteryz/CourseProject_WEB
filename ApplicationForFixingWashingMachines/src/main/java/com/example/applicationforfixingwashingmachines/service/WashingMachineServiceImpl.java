package com.example.applicationforfixingwashingmachines.service;

import com.example.applicationforfixingwashingmachines.entity.Problem;
import com.example.applicationforfixingwashingmachines.entity.Repair;
import com.example.applicationforfixingwashingmachines.entity.WashingMachine;
import com.example.applicationforfixingwashingmachines.exception.WashingMachineException;
import com.example.applicationforfixingwashingmachines.pojo.WashingMachinePojo;
import com.example.applicationforfixingwashingmachines.repository.ProblemRepository;
import com.example.applicationforfixingwashingmachines.repository.WashingMachineRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@EnableAsync
@Service
@RequiredArgsConstructor
public class WashingMachineServiceImpl implements WashingMachineService{

    private final WashingMachineRepository washingMachineRepository;

    private final ProblemRepository problemRepository;

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
    @Async
    @Scheduled(cron = "0 * * ? * *")//каждую минуту
    public void endOfAuction() {

        List<WashingMachine> list1 =
                washingMachineRepository
                        .findAllByEstimatedDateLessThanEqual(LocalDateTime.now());
        List<WashingMachine> list2 =
                washingMachineRepository
                        .findAllByFinishDateLessThanEqual(LocalDateTime.now());
        if(!list1.isEmpty()){
            list1.forEach(
                    value-> {
                        if(existRepair(value.getProblems())){
                            value.setWorkersFound(true);
                        }else{
                            //если на все проблемы не найдены сотрудники, то продлеваем аукцион
                            value.setEstimatedDate(LocalDateTime.now().plusDays(10));
                        }
                        washingMachineRepository.save(value);

                    }
            );
        }
        if(!list2.isEmpty()){
            list2.forEach(
                    value->
                    {
                        if(value.isWorkersFound())
                            washingMachineRepository.deleteById(value.getId());
                    }
            );
        }
    }

    @Transactional
    private boolean existRepair(List<Problem> list){
        for (Problem problem: list) {
            if(problem.getRepairs().isEmpty())
                return false;
            else {
                problem.setWorkersFound(true);
                problemRepository.save(problem);

            }
        }
        return true;
    }

}
