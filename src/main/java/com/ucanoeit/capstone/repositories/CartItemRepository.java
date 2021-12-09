package com.ucanoeit.capstone.repositories;

import com.ucanoeit.capstone.model.CartItem;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {

}
