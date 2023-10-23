package com.diamorph.springdata;

import com.diamorph.springdata.customer.jpa.CustomerRepository;
import com.diamorph.springdata.customer.models.Address;
import com.diamorph.springdata.customer.models.Customer;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void testCreate() {
		Customer customer = new Customer();
		customer.setName("Test");
		customer.setEmail("test@gmai.com");
		customerRepository.save(customer);
	}

	@Test
	public void testRead() {
		Customer customer = customerRepository.findById(1).get();
		assertNotNull(customer);
		assertEquals("Test", customer.getName());
	}

	@Test
	public void testUpdate() {
		Customer customer = customerRepository.findById(1).get();
		customer.setName("New User");
		customerRepository.save(customer);
		assertEquals("New User", customerRepository.findById(1).get().getName());
	}

	@Test
	public void testDelete() {
		assertEquals(true, customerRepository.existsById(1));
		customerRepository.deleteById(1);
		assertEquals(false, customerRepository.existsById(1));
	}

	@Test
	public void testCount() {
		System.out.println("Total Records: " + customerRepository.count());
	}

	@Test
	public void testFindByEmailAndName() {
		String searchEmail = "test@gmail.com";
		String searchName = "Test";
		List<Customer> customers = customerRepository.findByEmailAndName(searchEmail, searchName);
		customers.forEach(c -> {
			System.out.println("Email: " + c.getEmail() + " Name: " + c.getName());
			assertEquals(searchEmail, c.getEmail());
			assertEquals(searchName, c.getName());
		});

	}

	@Test
	public void testFindEmailLike() {
		String searchName = "gmail";
		List<Customer> customers = customerRepository.findByEmailLike("%" + searchName + "%");
		customers.forEach(c -> {
			System.out.println(c.getEmail());
			assertTrue(c.getEmail().contains(searchName));
		});

	}

	@Test
	public void testFindByIdIn() {
		int pageSize = 5;
		List<Customer> products = customerRepository.findByIdIn(Arrays.asList(1, 2, 3), PageRequest.of(0, pageSize));
		System.out.println(products);
		products.forEach(p -> {
			System.out.println(p.getName());
		});
		assertTrue(products.size() <= pageSize);
	}

	@Test
	@Transactional
	@Rollback(false)
	public void updateCustomerEmail() {
		String newEmail = "test123@gmail.com";
		int customerId = 1;
		customerRepository.updateCustomerEmail(customerId, newEmail);
		assertEquals(customerRepository.findById(customerId).get().getEmail(), newEmail);
	}

	@Test
	public void testAddCustomerWithAddress() {
		Address address = new Address("25 John St", "New York", "NY", "10038", "USA");
		Customer customer = new Customer();
		customer.setName("Vlad");
		customer.setEmail("test@gmail.com");
		customer.setAddress(address);
		Customer savedCustomer = customerRepository.save(customer);
		System.out.println(savedCustomer);
	}
}
