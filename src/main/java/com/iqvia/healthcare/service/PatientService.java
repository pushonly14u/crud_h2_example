package com.iqvia.healthcare.service;

import com.iqvia.healthcare.model.Patient;
import com.iqvia.healthcare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;


    public Iterable<Patient> findAll() {
        return patientRepository.findAll();
    }

    public String save(Patient patient) {
        patientRepository.save(patient);
        return "Saved";
    }

    public String ageAnalysis() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tAnalysis Based on Age ");
        sb.append("\nNo. of Patients under Age 30 : "+patientRepository.findAllByAgeBetween(0,30).size());
        sb.append("\nNo. of Patients between 30 to 60 : "+patientRepository.findAllByAgeBetween(30,60).size());
        sb.append("\nNo. of Patients above Age 60 "+patientRepository.findAllByAgeBetween(60,120).size());
        return sb.toString();

    }
    public String cityAnalysis() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tAnalysis Based on City ");
        for (String a: patientRepository.getCity()){
            sb.append("\nNo. of Patients in " +a+" : "+patientRepository.findAllByCity(a).size());
        }
        return sb.toString();

    }
    public String diseaseAnalysis() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tAnalysis Based on Disease ");
        for (String a: patientRepository.getDec()){
            sb.append("\nNo. of Patients Having " +a+" : "+patientRepository.findAllByDisease(a).size());
        }

        return sb.toString();

    }
}
