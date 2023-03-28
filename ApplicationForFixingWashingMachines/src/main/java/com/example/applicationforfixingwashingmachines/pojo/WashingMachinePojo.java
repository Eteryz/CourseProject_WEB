package com.example.applicationforfixingwashingmachines.pojo;

import com.example.applicationforfixingwashingmachines.entity.WashingMachine;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@ToString
public class WashingMachinePojo {

    private Long id;
    private String name;
    private String company;
    private LocalDateTime finishDate;
    private LocalDateTime estimatedDate;
    private boolean workersFound ;
    private List<ProblemPojo> problems = new LinkedList<>();

    public static WashingMachinePojo fromEntity(WashingMachine washingMachine) {
        WashingMachinePojo washingMachinePojo = new WashingMachinePojo();
        BeanUtils.copyProperties(washingMachine, washingMachinePojo);
        washingMachinePojo.setProblems(
                washingMachine.getProblems()
                        .stream()
                        .map(ProblemPojo::fromEntity)
                        .toList()
        );
        return washingMachinePojo;
    }

    public WashingMachine toEntity() {
        WashingMachine washingMachine = new WashingMachine();
        BeanUtils.copyProperties(this, washingMachine);
        return washingMachine;
    }
}
