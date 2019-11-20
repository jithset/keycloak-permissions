package com.jitihn.dto;

import com.jitihn.model.Product;

public class ProductDTO {
    private String pid;
    private String name;
    private Double price;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductDTO(Product product) {
        this.name = product.getName();
        this.pid = product.getPid();
        this.price = product.getPrice();
    }

}