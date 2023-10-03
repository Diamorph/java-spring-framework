package com.diamorph.springjpahibernate;

import com.diamorph.springjpahibernate.product.entities.Product;
import com.diamorph.springjpahibernate.product.jpa.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SpringJpaHibernateApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate() {
		Product product = new Product(1, "Iphone 15 Pro", "New", 1000d);
		productRepository.save(product);
	}

	@Test
	public void testRead() {
		Product product = productRepository.findById(1).get();
		assertNotNull(product);
		assertEquals("Iphone 15 Pro", product.getName());
	}

	@Test
	public void testUpdate() {
		Product product = productRepository.findById(1).get();
		product.setPrice(1500d);
		productRepository.save(product);
		assertEquals(1500d, productRepository.findById(1).get().getPrice());
	}

	@Test
	public void testDelete() {
		assertEquals(true, productRepository.existsById(1));
		productRepository.deleteById(1);
		assertEquals(false, productRepository.existsById(1));
	}

	@Test
	public void testCount() {
		System.out.println("Total Records: " + productRepository.count());
	}

}
