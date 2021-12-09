package com.ucanoeit.capstone.formmodel;

import com.ucanoeit.capstone.model.CartItem;
import com.ucanoeit.capstone.model.Product;
import com.ucanoeit.capstone.repositories.CartItemRepository;

import java.util.Collection;
import java.util.List;

public class CartItemSubmission {

    private Long productId;
    private int quantity;

    private final CartItemRepository cartItemRepository;

    public CartItemSubmission(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
