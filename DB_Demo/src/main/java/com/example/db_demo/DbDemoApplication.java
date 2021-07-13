package com.example.db_demo;

import com.example.db_demo.Customer.Customer;
import com.example.db_demo.Customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class DbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbDemoApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(CustomerRepository customerRepository, MongoTemplate mongoTemplate) {
//        return args -> {
//            Customer customer = new Customer("Chan", "Dai Man", LocalDateTime.now(), 1000);
//            customerRepository.insert(customer);
//            customerRepository.findCustomersByFirstName("Chan")
//                    .ifPresent(s -> System.out.println(s));
//        };
//    }

    private List<Customer> QueryUsingMongoTemplateAndQuery(MongoTemplate mongoTemplate, String firstName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("firstName").is(firstName));
        List<Customer> customers = mongoTemplate.find(query, Customer.class);
        return customers;
    }
}
