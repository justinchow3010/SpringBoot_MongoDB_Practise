package com.example.db_demo.Customer;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    List<Customer> findCustomersByFirstName(String firstName);

    Optional<Customer> findCustomerByEmail(String email);

    void deleteCustomerByEmail(String email);
}
