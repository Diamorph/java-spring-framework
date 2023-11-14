package com.diamorph.compositeKey;

import com.diamorph.compositeKey.entities.Customer;
import com.diamorph.compositeKey.entities.CustomerId;
import com.diamorph.compositeKey.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CompositeKeyApplicationTests {

	@Autowired
	CustomerRepository customerRepository;
//	@Test
//	void testSaveCustomer() {
//		Customer customer = new Customer();
//		customer.setId(123);
//		customer.setEmail("jack@gmail.com");
//		customer.setName("Jack");
//		Customer savedCustomer = customerRepository.save(customer);
//		assertNotNull(savedCustomer);
//	}

	@Test
	void testSaveCustomer() {
		Customer customer = new Customer();

		CustomerId customerId = new CustomerId();
		customerId.setId(1234);
		customerId.setEmail("jack123@gmail.com");

		customer.setId(customerId);
		customer.setName("Jack");
		Customer savedCustomer = customerRepository.save(customer);
		assertNotNull(savedCustomer);
	}

}
