package com.diamorph.patientscheduling.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp appointmentTime;
    private boolean started;
    private boolean ended;
    private String reason;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;
}
