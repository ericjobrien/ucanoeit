package com.ucanoeit.capstone.repositories;

import com.ucanoeit.capstone.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.HashMap;
import java.util.Map;

public interface CustomerRepository extends CrudRepository<Customer, String> {

}
