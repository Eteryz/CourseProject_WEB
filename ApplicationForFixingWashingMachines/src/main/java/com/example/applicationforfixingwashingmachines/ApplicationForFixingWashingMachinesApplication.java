package com.example.applicationforfixingwashingmachines;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ApplicationForFixingWashingMachinesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationForFixingWashingMachinesApplication.class, args);
	}

}
