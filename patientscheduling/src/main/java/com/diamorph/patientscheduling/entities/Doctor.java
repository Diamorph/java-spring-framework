package com.diamorph.patientscheduling.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String speciality;
    @ManyToMany(mappedBy = "doctors")
    private List<Patient> patients;
    @OneToMany
    private List<Appointment> appointments;
}
