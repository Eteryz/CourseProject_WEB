package com.example.applicationforfixingwashingmachines.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "washingMachines")
public class WashingMachine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String company;

    private LocalDateTime finishDate;

    private LocalDateTime estimatedDate;

    private boolean workersFound = false;

    @OneToMany(mappedBy = "washingMachine", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Problem> problems = new LinkedList<>();

}
