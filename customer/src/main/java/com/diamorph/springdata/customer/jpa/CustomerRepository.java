package com.diamorph.springdata.customer.jpa;

import com.diamorph.springdata.customer.models.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByEmailAndName(String email, String name);
    List<Customer> findByEmailLike(String email);
    List<Customer> findByIdIn(List<Integer> id, Pageable pageable);

    @Modifying
    @Query("UPDATE Customer c SET c.email=:email WHERE c.id=:id")
    void updateCustomerEmail(@Param("id") int id, @Param("email") String email);
}
