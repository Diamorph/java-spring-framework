package com.diamorph.associations.repositories;

import com.diamorph.associations.entities.onetomany.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> { }
