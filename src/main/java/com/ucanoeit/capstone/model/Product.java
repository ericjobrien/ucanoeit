package com.ucanoeit.capstone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer productcategoryid;
    private Integer brandid;
    private String productname;
    private Integer width;
    private Integer length;
    private Integer weight;
    private Integer maxcapacity;
    private float price;
    private Integer inventory;
    private String imageurl;


    public Product(Long id, Integer productcategoryid, Integer brandid, String productname, Integer width, Integer length, Integer weight, Integer maxcapacity, float price, Integer inventory, String imageurl) {
        this.id = id;
        this.productcategoryid = productcategoryid;
        this.brandid = brandid;
        this.productname = productname;
        this.width = width;
        this.length = length;
        this.weight = weight;
        this.maxcapacity = maxcapacity;
        this.price = price;
        this.inventory = inventory;
        this.imageurl = imageurl;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProductcategoryid() {
        return productcategoryid;
    }

    public void setProductcategoryid(Integer productcategoryid) {
        this.productcategoryid = productcategoryid;
    }

    public Integer getBrandid() {
        return brandid;
    }

    public void setBrandid(Integer brandid) {
        this.brandid = brandid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getMaxcapacity() {
        return maxcapacity;
    }

    public void setMaxcapacity(Integer maxcapacity) {
        this.maxcapacity = maxcapacity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productcategoryid=" + productcategoryid +
                ", brandid=" + brandid +
                ", productname='" + productname + '\'' +
                ", width=" + width +
                ", length=" + length +
                ", weight=" + weight +
                ", maxcapacity=" + maxcapacity +
                ", price=" + price +
                ", inventory=" + inventory +
                ", imageurl='" + imageurl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return id != null ? id.equals(product.id) : product.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
