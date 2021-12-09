package com.ucanoeit.capstone.formmodel;

import com.ucanoeit.capstone.repositories.CustomerRepository;

public class CustomerSubmission {

    private String email;
    private String password;

    private final CustomerRepository customerRepository;

    public CustomerSubmission(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
