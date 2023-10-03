package com.diamorph.springdata;

import com.diamorph.springdata.customer.jpa.CustomerRepository;
import com.diamorph.springdata.customer.models.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

}
