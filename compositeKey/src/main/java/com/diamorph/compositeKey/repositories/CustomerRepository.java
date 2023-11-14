package com.diamorph.compositeKey.repositories;

import com.diamorph.compositeKey.entities.Customer;
import com.diamorph.compositeKey.entities.CustomerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, CustomerId> {}
