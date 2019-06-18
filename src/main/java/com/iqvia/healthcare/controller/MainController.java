package com.iqvia.healthcare.controller;

import com.iqvia.healthcare.model.Patient;
import com.iqvia.healthcare.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired
    private PatientService patientService;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestBody Patient patient) {

        return patientService.save(patient);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Patient> getAllUsers() {
        return patientService.findAll();
    }

    @GetMapping(path="/analysis")
    public @ResponseBody String getData() {
        return patientService.ageAnalysis()+"\n\n"+patientService.cityAnalysis()+"\n\n"+patientService.diseaseAnalysis();
    }



}
