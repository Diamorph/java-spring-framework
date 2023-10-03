package com.diamorph.springdata.customer.jpa;

import com.diamorph.springdata.customer.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> { }
