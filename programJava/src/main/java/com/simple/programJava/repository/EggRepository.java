package com.simple.programJava.repository;

import com.simple.programJava.model.EggModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EggRepository extends JpaRepository<EggModel, Long> {
}
