package com.ucanoeit.capstone.repositories;

import com.ucanoeit.capstone.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
