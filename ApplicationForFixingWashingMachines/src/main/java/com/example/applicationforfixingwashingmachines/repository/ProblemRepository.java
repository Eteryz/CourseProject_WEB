package com.example.applicationforfixingwashingmachines.repository;

import com.example.applicationforfixingwashingmachines.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<Problem, Long > {
}
