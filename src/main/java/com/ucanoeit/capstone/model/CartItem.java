package com.ucanoeit.capstone.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cartitem")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @ManyToOne
    private Product product;

    public CartItem(Long id, int quantity, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
    }

    public CartItem() {
    }

    public Product getProduct() {
        return product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public double getTotalPrice() {
        this.product = product;
        double productPrice = product.getPrice();
        this.quantity = quantity;

        return productPrice * quantity;
    }

    public double getEstimatedTaxes() {
        double estTaxes = getTotalPrice() * .07;
        return estTaxes;
    }

    public double getTotalCost() {
        double estTaxes = getEstimatedTaxes();
        double priceOfItems = getTotalPrice();
        return estTaxes + priceOfItems;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItem cartItem = (CartItem) o;

        return id != null ? id.equals(cartItem.id) : cartItem.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
