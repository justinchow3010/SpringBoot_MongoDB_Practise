package com.example.db_demo.Customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private boolean checkEmailExist(String email) {
        Optional<Customer> checking = customerRepository.findCustomerByEmail(email);
        return checking.isPresent();
    }

    public List<Customer> fetchAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Customer> findCustomersByFirstName(String firstName) {
        if (firstName != null) {
            return customerRepository.findCustomersByFirstName(firstName);
        } else {
            return customerRepository.findAll();
        }
    }

    public void addCustomer(Customer customer) {
        if (checkEmailExist(customer.getEmail())) {
            throw new IllegalStateException("The customer already exists.");
        } else {
            customerRepository.insert(customer);
        }
    }

    public void updateCustomerByEmail(String email) {
        if (!checkEmailExist(email)) {
            throw new IllegalStateException("The customer does not exist.");
        } else {
            Optional<Customer> toBeChanged = customerRepository.findCustomerByEmail(email);
            toBeChanged.ifPresent(body -> {
                body.setTotalSpent(100);
                customerRepository.save(body);
            });
        }
    }

    public void deleteCustomerByEmail(String email) {
        if (!checkEmailExist(email)) {
            throw new IllegalStateException("The customer does not exist.");
        } else {
            customerRepository.deleteCustomerByEmail(email);
        }
    }
}
