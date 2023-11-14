package com.diamorph.patientscheduling.repositories;

import com.diamorph.patientscheduling.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
