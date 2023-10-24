package com.diamorph.associations.repositories;

import com.diamorph.associations.entities.onetoone.License;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseRepository extends JpaRepository<License, Long> { }
