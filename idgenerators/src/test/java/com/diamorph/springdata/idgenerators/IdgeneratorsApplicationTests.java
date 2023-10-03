package com.diamorph.springdata.idgenerators;

import com.diamorph.springdata.idgenerators.jpa.EmployeeRepository;
import com.diamorph.springdata.idgenerators.models.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IdgeneratorsApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;
	@Test
	public void createEmployee() {
		Employee employee = new Employee();
		employee.setName("John");
		employeeRepository.save(employee);
	}

}
