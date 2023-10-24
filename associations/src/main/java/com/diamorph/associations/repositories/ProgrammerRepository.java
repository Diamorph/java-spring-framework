package com.diamorph.associations.repositories;

import com.diamorph.associations.entities.manytomany.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammerRepository extends JpaRepository<Programmer, Long> { }
