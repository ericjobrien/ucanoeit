package com.ucanoeit.capstone.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private Double totalprice;

    @Transient
    private int itemsnumber;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<CartItem> items;

    private String tokensession;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalprice() {
        Double sum = 0.0;
        for(CartItem item : this.items) {
            sum = sum + item.getProduct().getPrice();
        }
        return sum;
    }


    public int getItemsnumber() {
        return this.items.size();
    }

    public void setItemsnumber(int itemsnumber) {
        this.itemsnumber = itemsnumber;
    }

    public Collection<CartItem> getItems() {
        return items;
    }

    public void setItems(Collection<CartItem> items) {
        this.items = items;
    }

    public String getTokensession() {
        return tokensession;
    }

    public void setTokensession(String tokensession) {
        this.tokensession = tokensession;
    }
}
