package com.diamorph.associations;

import com.diamorph.associations.entities.manytomany.Programmer;
import com.diamorph.associations.entities.manytomany.Project;
import com.diamorph.associations.entities.onetomany.Customer;
import com.diamorph.associations.entities.onetomany.PhoneNumber;
import com.diamorph.associations.entities.onetoone.License;
import com.diamorph.associations.entities.onetoone.Person;
import com.diamorph.associations.repositories.CustomerRepository;
import com.diamorph.associations.repositories.LicenseRepository;
import com.diamorph.associations.repositories.ProgrammerRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
class AssociationsApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	ProgrammerRepository programmerRepository;

	@Autowired
	LicenseRepository licenseRepository;

	@Test
	void contextLoads() {
	}

	// One To Many
	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setName("Jake");
		HashSet<PhoneNumber> numbers = new HashSet<>();
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber("123-456-7890");
		ph1.setType("cell");
		ph1.setCustomer(customer);
		numbers.add(ph1);
		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumber("456-123-7890");
		ph2.setType("home");
		ph2.setCustomer(customer);
		numbers.add(ph2);
		customer.setNumbers(numbers);
		Customer savedCustomer = customerRepository.save(customer);
	}

	@Test
	public void testCreateCustomer_1() {
		Customer customer = new Customer();
		customer.setName("John");
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber("123-456-7890");
		ph1.setType("cell");
		customer.addPhoneNumber(ph1);
		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumber("456-123-7890");
		ph2.setType("home");
		ph2.setCustomer(customer);
		customer.addPhoneNumber(ph2);
		Customer savedCustomer = customerRepository.save(customer);
	}

	@Test
	@Transactional
	public void testLoadCustomer() {
		Customer customer = customerRepository.findById(6L).get();
		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(System.out::println);
		System.out.println(customer.getName());
	}

	@Test
	public void testUpdateCustomer() {
		Customer customer = customerRepository.findById(6L).get();
		customer.setName("John Baker");
		customer.getNumbers().forEach(n -> n.setType("cell"));
		customerRepository.save(customer);
	}

	@Test
	public void testDeleteCustomer() {
		customerRepository.deleteById(4L);
	}

	// Many To Many
	@Test
	public void testCreateProgrammer() {
		Project project = new Project();
		project.setName("Test project");
		HashSet<Project> projects = new HashSet<>();
		projects.add(project);

		Programmer programmer = new Programmer();
		programmer.setName("John");
		programmer.setSalary(100000);
		programmer.setProjects(projects);

		programmerRepository.save(programmer);
	}

	@Test
	@Transactional // need for load related data when fetch = fetch = FetchType.LAZY
	public void testFindProgrammer() {
		Programmer programmer = programmerRepository.findById(1L).get();
		System.out.println(programmer);
		System.out.println(programmer.getProjects());
	}

	// One to One

	@Test
	public void testCreateLicence() {
		Person person = new Person();
		person.setFirstName("John");
		person.setLastName("Baker");
		person.setAge(25);

		License license = new License();
		license.setType("CAR");
		LocalDate currentDate = LocalDate.now();
		license.setValidTo(currentDate);
		license.setValidFrom(currentDate.plusYears(5));

		license.setPerson(person);

		License savedLicense = licenseRepository.save(license);
		System.out.println(savedLicense);
	}
}
