package com.example.applicationforfixingwashingmachines.pojo;

import com.example.applicationforfixingwashingmachines.entity.Repair;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class RepairPojo {

    private Long id;
    private String phoneNumber;
    private String email;
    private double price;
    private String fullName;
    private LocalDateTime time;
    private Long problemId;


    public static RepairPojo fromEntity(Repair repair) {
        RepairPojo repairPojo = new RepairPojo();
        BeanUtils.copyProperties(repair, repairPojo);
        repairPojo.setProblemId(repair.getProblem().getId());
        return repairPojo;
    }

    public Repair toEntity(){
        Repair repair = new Repair();
        BeanUtils.copyProperties(this,repair);
        return repair;
    }

}
