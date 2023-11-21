package com.diamorph.clinicalAPI.controllers;

import com.diamorph.clinicalAPI.dto.ClinicalDataRequestDTO;
import com.diamorph.clinicalAPI.model.ClinicalData;
import com.diamorph.clinicalAPI.model.Patient;
import com.diamorph.clinicalAPI.repositories.ClinicalDataRepository;
import com.diamorph.clinicalAPI.repositories.PatientRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClinicalDataController {

    private ClinicalDataRepository clinicalDataRepository;
    private PatientRepository patientRepository;

    ClinicalDataController(ClinicalDataRepository clinicalDataRepository, PatientRepository patientRepository) {
        this.clinicalDataRepository = clinicalDataRepository;
        this.patientRepository = patientRepository;
    }

    @PostMapping("/clinicals")
    public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequestDTO request) {
        int patientId = request.getPatientId();
        Patient patient = patientRepository.findById(patientId).get();

        ClinicalData clinicalData = new ClinicalData();
        clinicalData.setComponentName(request.getComponentName());
        clinicalData.setComponentValue(request.getComponentValue());
        clinicalData.setPatient(patient);

        return clinicalDataRepository.save(clinicalData);
    }
}
