package com.diamorph.patientscheduling.repositories;

import com.diamorph.patientscheduling.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
