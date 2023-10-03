package com.diamorph.springdata.idgenerators.jpa;

import com.diamorph.springdata.idgenerators.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> { }
