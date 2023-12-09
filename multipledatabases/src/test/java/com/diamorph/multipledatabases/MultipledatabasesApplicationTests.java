package com.diamorph.multipledatabases;

import com.diamorph.multipledatabases.coupon.entities.Coupon;
import com.diamorph.multipledatabases.coupon.repositories.CouponRepository;
import com.diamorph.multipledatabases.product.entities.Product;
import com.diamorph.multipledatabases.product.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class MultipledatabasesApplicationTests {

	@Autowired
	CouponRepository couponRepository;

	@Autowired
	ProductRepository productRepository;

	@Test
	void testCouponSave() {
		Coupon coupon = new Coupon();
		coupon.setCode("SALE");
		coupon.setDiscount(new BigDecimal("20"));
		coupon.setExpDate("12/23/2025");
		Coupon savedCoupon = couponRepository.save(coupon);
		System.out.println(savedCoupon);
	}

	@Test
	void testProductSave() {
		Product product = new Product();
		product.setName("Macbook Pro 14");
		product.setDescription("ARM");
		product.setPrice(new BigDecimal("2000"));
		product.setCouponCode("SALE");
		Product savedProduct = productRepository.save(product);
		System.out.println(savedProduct);
	}

}
