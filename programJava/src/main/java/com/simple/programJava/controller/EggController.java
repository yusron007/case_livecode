package com.simple.programJava.controller;

import com.simple.programJava.model.EggModel;
import com.simple.programJava.service.EggService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eggs")
public class EggController {

    @Autowired
    private EggService eggService;

    @PostMapping
    public EggModel addEggRecord(@RequestBody EggModel eggRecord) {
        return eggService.addEggRecord(eggRecord);
    }

    @GetMapping("/income")
    public int getIncome() {
        return eggService.calculateIncome();
    }

    @GetMapping
    public List<EggModel> getAllEggRecords() {
        return eggService.getAllEggRecords();
    }
}
