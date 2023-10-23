package com.diamorph.springdata.componentmapping.repositories;

import com.diamorph.springdata.componentmapping.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> { }
