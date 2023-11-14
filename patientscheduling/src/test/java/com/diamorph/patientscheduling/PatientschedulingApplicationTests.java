package com.diamorph.patientscheduling;

import com.diamorph.patientscheduling.entities.Appointment;
import com.diamorph.patientscheduling.entities.Doctor;
import com.diamorph.patientscheduling.entities.Insurance;
import com.diamorph.patientscheduling.entities.Patient;
import com.diamorph.patientscheduling.repositories.AppointmentRepository;
import com.diamorph.patientscheduling.repositories.DoctorRepository;
import com.diamorph.patientscheduling.repositories.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
class PatientschedulingApplicationTests {

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private AppointmentRepository appointmentRepository;
	@Test
	void testCreateDoctor() {
		Doctor doctor = new Doctor();
		doctor.setFirstName("Greg");
		doctor.setLastName("House");
		doctor.setSpeciality("Medical Doctor");
		doctorRepository.save(doctor);
	}

	@Test
	void testCreatePatient() {
		Patient patient = new Patient();
		patient.setFirstName("John");
		patient.setLastName("Smith");
		patient.setPhone("+1 (980) 930-9394");
		// create insurance
		Insurance insurance = new Insurance("AmBetter", 20d);
		patient.setInsurance(insurance);

		Doctor doctor = doctorRepository.findById(1L).get();

		List<Doctor> doctors = Arrays.asList(doctor);

		patient.setDoctors(doctors);

		patientRepository.save(patient);
	}

	@Test
	void testCreateAppointment() {
		Appointment appointment = new Appointment();
		Timestamp appointmentTime = new Timestamp(new Date().getTime());
		appointment.setAppointmentTime(appointmentTime);
		appointment.setReason("Sore throat");
		appointment.setStarted(true);

		Patient patient = patientRepository.findById(4L).get();
		appointment.setPatient(patient);

		Doctor doctor = doctorRepository.findById(1L).get();
		appointment.setDoctor(doctor);

		appointment.setEnded(false);
		appointmentRepository.save(appointment);
	}

}
