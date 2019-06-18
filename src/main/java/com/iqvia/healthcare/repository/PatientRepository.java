package com.iqvia.healthcare.repository;

import com.iqvia.healthcare.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> findAllByAgeBetween(int age1,int age2);

    @Query("SELECT DISTINCT disease from Patient")
    List<String> getDec();

    List<Patient> findAllByDisease(String a);

    @Query("SELECT DISTINCT city from Patient")
    List<String> getCity();

    List<Patient> findAllByCity(String a);
}
