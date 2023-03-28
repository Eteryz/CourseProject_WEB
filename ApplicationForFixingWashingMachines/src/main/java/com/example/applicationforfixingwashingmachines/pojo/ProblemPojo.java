package com.example.applicationforfixingwashingmachines.pojo;

import com.example.applicationforfixingwashingmachines.entity.Problem;
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
public class ProblemPojo {

    private Long id;
    private String description;
    private double price;
    private LocalDateTime estimatedDate;
    private LocalDateTime finishDate;
    private Long washingMachineId;
    private List<RepairPojo> repairs = new LinkedList<>();


    public static ProblemPojo fromEntity(Problem problem) {
        ProblemPojo problemPojo = new ProblemPojo();
        BeanUtils.copyProperties(problem, problemPojo);
        problemPojo.setRepairs(
                problem.getRepairs()
                        .stream()
                        .map(RepairPojo::fromEntity)
                        .toList()
        );
        problemPojo.setWashingMachineId(problem.getWashingMachine().getId());
        return problemPojo;
    }

    public Problem toEntity(){
        Problem problem = new Problem();
        BeanUtils.copyProperties(this,problem);
        return problem;
    }
}
