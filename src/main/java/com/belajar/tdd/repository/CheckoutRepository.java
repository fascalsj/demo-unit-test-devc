package com.belajar.tdd.repository;

import com.belajar.tdd.entity.CheckoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRepository extends JpaRepository<CheckoutEntity, Integer> {
}
