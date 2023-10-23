package com.diamorph.springdata.componentmapping;

import com.diamorph.springdata.componentmapping.entities.Address;
import com.diamorph.springdata.componentmapping.entities.Employee;
import com.diamorph.springdata.componentmapping.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ComponentmappingApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createEmployee() {
		Address address = new Address("25 John St", "New York", "NY", "10038", "USA");
		Employee employee = new Employee();
		employee.setName("Test1");
		employee.setAddress(address);
		Employee savedEmployee = employeeRepository.save(employee);
		System.out.println(savedEmployee);
	}

}
