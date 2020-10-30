package com.ala.salonapi.domain.repository;

import com.ala.salonapi.domain.Payment;

import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
