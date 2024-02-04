package com.l2c.ecommmerce.dao;

import com.l2c.ecommmerce.enitity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
}
