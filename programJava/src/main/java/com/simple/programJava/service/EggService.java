package com.simple.programJava.service;

import com.simple.programJava.model.EggModel;
import com.simple.programJava.repository.EggRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EggService {

    @Autowired
    private EggRepository eggRepository;

    public EggModel addEggRecord(EggModel eggRecord) {
        return eggRepository.save(eggRecord);
    }

    public int calculateIncome() {
        List<EggModel> eggRecords = eggRepository.findAll();
        return eggRecords.stream()
                .mapToInt(record -> record.getQuantity() * record.getPricePerEgg())
                .sum();
    }

    public List<EggModel> getAllEggRecords() {
        return eggRepository.findAll();
    }
}
