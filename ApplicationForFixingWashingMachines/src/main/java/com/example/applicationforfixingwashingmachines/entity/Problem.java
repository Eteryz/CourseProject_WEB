package com.example.applicationforfixingwashingmachines.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@SQLDelete(sql = "UPDATE burmistrov.public.problems SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Table(name = "problems")
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private double price;

    private LocalDateTime finishDate;

    private boolean workersFound = Boolean.FALSE;

    private boolean deleted = Boolean.FALSE;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "washingMachines_id")
    private WashingMachine washingMachine;

    @OneToMany( mappedBy = "problem", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Repair> repairs = new LinkedList<>();

}
