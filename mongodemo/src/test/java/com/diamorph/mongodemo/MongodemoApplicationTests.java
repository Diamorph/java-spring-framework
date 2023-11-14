package com.diamorph.mongodemo;

import com.diamorph.mongodemo.models.Product;
import com.diamorph.mongodemo.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MongodemoApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void testSave() {
		Product product = new Product();
		product.setName("Macbook Pro 14 inch");
		product.setPrice(2000f);
		Product savedProduct = productRepository.save(product);
		assertNotNull(savedProduct);
	}

	@Test
	void testFindAll() {
		List<Product> products = productRepository.findAll();
        assertFalse(products.isEmpty());
	}

	@Test
	void testDeleteById() {
		productRepository.deleteById("6553b30942ee136ce3c5befc");
		Optional<Product> product = productRepository.findById("6553b30942ee136ce3c5befc");
		assertTrue(product.isEmpty());
	}

	@Test
	void testUpdateById() {
		Optional<Product> retrievedProduct = productRepository.findById("6553b317d13cf06bad8f7e04");
		if (retrievedProduct.isEmpty()) {
			return;
		}
		float newPrice = 2500f;
		Product product = retrievedProduct.get();
		product.setPrice(newPrice);
		Product updatedProduct = productRepository.save(product);
		assertEquals(updatedProduct.getPrice(), newPrice);
	}

}
