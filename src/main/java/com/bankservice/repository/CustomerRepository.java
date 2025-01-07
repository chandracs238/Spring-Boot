package com.bankservice.repository;

import com.bankservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByCustomerName(String customerName);
    Optional<Customer> findByEmail(String email);
}
