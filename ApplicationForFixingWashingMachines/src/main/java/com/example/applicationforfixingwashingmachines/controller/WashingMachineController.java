package com.example.applicationforfixingwashingmachines.controller;

import com.example.applicationforfixingwashingmachines.exception.WashingMachineException;
import com.example.applicationforfixingwashingmachines.pojo.WashingMachinePojo;
import com.example.applicationforfixingwashingmachines.service.WashingMachineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@Log4j2
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value = "/api/v1/washingMachine")
@RequiredArgsConstructor
public class WashingMachineController {

    private final WashingMachineService washingMachineService;

    @PostMapping("/add")
    public WashingMachinePojo addWashingMachine(@RequestBody WashingMachinePojo washingMachinePojo){

        LocalDateTime dateTime = washingMachinePojo.getEstimatedDate();

        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, dateTime.getYear());
        calendar.set(Calendar.MONTH, dateTime.getMonthValue()-1);
        calendar.set(Calendar.DAY_OF_MONTH, dateTime.getDayOfMonth());
        calendar.set(Calendar.HOUR_OF_DAY, dateTime.getHour());
        calendar.set(Calendar.MINUTE, dateTime.getMinute());
        calendar.set(Calendar.SECOND, dateTime.getSecond());


//        Calendar calendar = new GregorianCalendar();
//        calendar.set(Calendar.YEAR, 2023);
//        calendar.set(Calendar.MONTH, Calendar.APRIL);
//        calendar.set(Calendar.DAY_OF_MONTH, 12);
//        calendar.set(Calendar.HOUR_OF_DAY, 5);
//        calendar.set(Calendar.MINUTE, 31);
//        calendar.set(Calendar.SECOND, 0);
        Date date = calendar.getTime();
        log.info(calendar.toString());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                washingMachineService.endOfAuction();
            }
        }, date);
        return washingMachineService.save(washingMachinePojo);
    }

    @GetMapping()
    public List<WashingMachinePojo> getAll(){
        return washingMachineService.findAll();
    }

    @GetMapping("/{id}")
    public WashingMachinePojo getById(@PathVariable Long id)  {
        try {
            return washingMachineService.getById(id);
        } catch (WashingMachineException e) {
            return null;
        }
    }

    private void test(){
        log.info("Task completed!");
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return washingMachineService.deleteById(id);
    }

    @GetMapping("/count")
    public long count(){
        return washingMachineService.count();
    }
}
