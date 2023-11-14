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
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    @Embedded
    private Insurance insurance;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "patients_doctors",
        joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    )
    List<Doctor> doctors;

    @OneToMany
    private List<Appointment> appointments;
}
