package com.example.applicationforfixingwashingmachines.service;

import com.example.applicationforfixingwashingmachines.pojo.ProblemPojo;

import java.util.List;

public interface ProblemService {
    ProblemPojo save(ProblemPojo problemPojo);

    boolean deleteById(long id);

    long count();

    List<ProblemPojo> findAll();
}
