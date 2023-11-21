package com.diamorph.clinicalAPI.controllers;

import com.diamorph.clinicalAPI.model.ClinicalData;
import com.diamorph.clinicalAPI.model.Patient;
import com.diamorph.clinicalAPI.repositories.PatientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PatientController {
    private PatientRepository patientRepository;

    PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatient(@PathVariable("id") int id) {
        return patientRepository.findById(id).orElse(null);
    }

    @PostMapping("/patients")
    public Patient savePatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @GetMapping("/patients/analyze/{id}")
    public Patient analyze(@PathVariable("id") int id) {
        Patient patient = patientRepository.findById(id).get();
        List<ClinicalData> clinicalData = patient.getClinicalData();
        List<ClinicalData> duplicateClinicalData = clinicalData.stream().toList();

        HashMap<String, ClinicalData> clinicalDataMap = new HashMap<>();

        duplicateClinicalData.forEach(entry -> {
            if (clinicalDataMap.containsKey(entry.getComponentName())) {
                clinicalData.remove(entry);
            } else {
                clinicalDataMap.put(entry.getComponentName(), entry);
                if (entry.getComponentName().equals("hw")) {
                    String[] heightAndWeight = entry.getComponentValue().split("/");
                    if (heightAndWeight.length > 1) {
                        float heightInMeters = Float.parseFloat(heightAndWeight[0]) * 0.4536F;
                        float bmi = (float) (Float.parseFloat(heightAndWeight[1]) / Math.pow(heightInMeters, 2));
                        ClinicalData bmiData = new ClinicalData();
                        bmiData.setComponentName("bmi");
                        bmiData.setComponentValue(Float.toString(bmi));
                        clinicalData.add(bmiData);
                    }
                }
            }
        });

        return patient;
    }
}
