package com.diamorph.mongodemo.repositories;

import com.diamorph.mongodemo.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> { }
