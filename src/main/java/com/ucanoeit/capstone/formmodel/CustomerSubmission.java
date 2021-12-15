package com.ucanoeit.capstone.formmodel;

import com.ucanoeit.capstone.repositories.CustomerRepository;

public class CustomerSubmission {

    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private Boolean admin;

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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }
}
