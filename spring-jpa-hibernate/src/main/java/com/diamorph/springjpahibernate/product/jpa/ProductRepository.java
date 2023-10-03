package com.diamorph.springjpahibernate.product.jpa;

import com.diamorph.springjpahibernate.product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
