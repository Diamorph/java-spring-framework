package com.diamorph.springjpahibernate;

import com.diamorph.springjpahibernate.product.entities.Product;
import com.diamorph.springjpahibernate.product.jpa.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringJpaHibernateApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	EntityManager entityManager;

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

	@Test
	public void testFindByName() {
		List<Product> products = productRepository.findByName("IWatch");
		products.forEach(p -> assertEquals("IWatch", p.getName()));
	}

	@Test
	public void testFindByNameAndDesc() {
		List<Product> products = productRepository.findByNameAndDesc("IWatch", "new");
		products.forEach(p -> {
			assertEquals("IWatch", p.getName());
			assertEquals("new", p.getDesc());
		});
	}

	@Test
	public void testFindByPriceGreaterThan() {
		List<Product> products = productRepository.findByPriceGreaterThan(1000d);
		products.forEach(p -> {
			System.out.println("Price: " + p.getPrice());
			assertTrue(1000d < p.getPrice());
		});
	}

	@Test
	public void testFindByDescContains() {
		String searchString = "From";
		List<Product> products = productRepository.findByDescContains(searchString);
		products.forEach(p -> {
			System.out.println("Desc: " + p.getDesc());
			assertTrue(p.getDesc().contains(searchString));
		});
	}

	@Test
	public void testFindByPriceBetween() {
		double price1 = 500d;
		double price2 = 2500d;
		List<Product> products = productRepository.findByPriceBetween(price1, price2);
		products.forEach(p -> {
			System.out.println("Price: " + p.getPrice());
			assertTrue(price1 < p.getPrice());
			assertTrue(price2 > p.getPrice());
		});
	}

	@Test
	public void testFindByDescLike() {
		String desc = "LG";
		List<Product> products = productRepository.findByDescLike("%" + desc + "%");
		products.forEach(p -> {
			System.out.println("Desc: " + p.getDesc());
			assertTrue(p.getDesc().contains(desc));
		});
	}

	@Test
	public void testFindByIdIn() {
		Page<Product> products = productRepository.findByIdIn(Arrays.asList(1, 2, 3, 4, 5), PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "price")));
		products.forEach(p -> {
			System.out.println("Name: " + p.getName() + " Price: " + p.getPrice());
		});
		assertEquals(5, products.stream().count());
	}

	@Test
	public void testFindAllPaging() {
		Pageable pageable = PageRequest.of(0, 2);
		Page<Product> results = productRepository.findAll(pageable);
		results.forEach(r -> System.out.println(r.getName()));
	}

	@Test
	public void testFindAllSorting() {
		List<Product> results = productRepository.findAll(Sort.by(Sort.Direction.DESC, "name", "price"));
		results.forEach(r -> System.out.println(r.getName()));
	}

	@Test
	public void testFindAllSortingMultipleOrders() {
		List<Product> results = productRepository.findAll(
				Sort.by(
						new Sort.Order(Sort.Direction.DESC, "name"),
						new Sort.Order(Sort.Direction.DESC, "price")
				)
		);
		results.forEach(r -> {
			System.out.println("Name: " + r.getName() + " Price: " + r.getPrice());
		});
	}

	@Test
	public void testFindAllPagingAndSorting() {
		PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "name"));
		Page<Product> results = productRepository.findAll(pageRequest);
		results.forEach(r -> {
			System.out.println("Name: " + r.getName() + " Price: " + r.getPrice());
		});
	}

	@Test
	@Transactional
	public void testCaching() {
		Session session = entityManager.unwrap(Session.class);
		Product product = productRepository.findById(1).get();
		System.out.println(product);
		System.out.println("Second level cache: " + session.getSessionFactory().getCache().contains(Product.class, 1));;
		Product product1 = productRepository.findById(1).get();
//		System.out.println(CacheManager.ALL_CACHE_MANAGERS.size());
		session.evict(product);
		Product product2 = productRepository.findById(1).get();
	}


	@Test
	public void testFindAllProducts() {
		List<Product> products = productRepository.findAllProducts();
		products.forEach(System.out::println);
        assertFalse(products.isEmpty());
	}

	@Test
	public void testFindAllProductsByPrice() {
		List<Product> products = productRepository.findAllProductsByPrice(999);
		products.forEach(System.out::println);
		assertFalse(products.isEmpty());
	}

	@Test
	public void testFindAllProductsCountByPrice() {
		int allProductsCountByPrice = productRepository.findAllProductsCountByPrice(999);
		System.out.println(allProductsCountByPrice);
		assertTrue(allProductsCountByPrice != 0);
	}

}
