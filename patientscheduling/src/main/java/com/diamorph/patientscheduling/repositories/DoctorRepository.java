package com.diamorph.patientscheduling.repositories;

import com.diamorph.patientscheduling.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
