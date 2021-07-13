package com.example.db_demo.Customer;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Indexed;

import java.time.LocalDateTime;

@Data //define getters and setters automatically!!!
@Document //For mongodb
public class Customer {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private LocalDateTime createdAt;
    private String email;
    private int totalSpent;

    //    @Indexed to set unique field
    public Customer(String firstName, String lastName, LocalDateTime createdAt, String email, int totalSpent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = createdAt;
        this.email = email;
        this.totalSpent = totalSpent;
    }
}
