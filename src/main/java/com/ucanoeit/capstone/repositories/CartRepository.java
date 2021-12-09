package com.ucanoeit.capstone.repositories;

import com.ucanoeit.capstone.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
//    Cart findBySessionToken(String sessionToken);
}
