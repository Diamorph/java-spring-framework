package com.diamorph.multipledatabases.product.repositories;

import com.diamorph.multipledatabases.product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
