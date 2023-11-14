package com.diamorph.patientscheduling.entities;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@ToString
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Insurance {
    private String providerName;
    private double copay;
}
