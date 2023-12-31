package com.diamorph.multipledatabases.coupon.repositories;

import com.diamorph.multipledatabases.coupon.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
