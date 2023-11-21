package com.diamorph.clinicalAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClinicalDataRequestDTO {
    private String componentName;
    private String componentValue;
    private int patientId;
}
