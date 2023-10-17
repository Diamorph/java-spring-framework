package com.diamorph.springdata.hibernateinheritance.repositories;

import com.diamorph.springdata.hibernateinheritance.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
