package com.diamorph.clinicalAPI.repositories;

import com.diamorph.clinicalAPI.model.ClinicalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Integer> { }
