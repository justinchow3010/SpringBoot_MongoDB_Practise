package com.example.db_demo.Customer;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping
    public List<Customer> findCustomersByFirstName(@RequestParam(required = false) String firstName) {
        return customerService.findCustomersByFirstName(firstName);
    }

    @PostMapping
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @PutMapping(path = "/{email}")
    public void updateCustomer(@PathVariable String email) {
        customerService.updateCustomerByEmail(email);
    }

    @DeleteMapping(path = "/{email}")
    public void deleteCustomerByEmail(@PathVariable String email) {
        customerService.deleteCustomerByEmail(email);
    }
}
