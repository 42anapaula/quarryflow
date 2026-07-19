package com.ana.quarryflow.core.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Material {

    private UUID id;
    private String name;
    private BigDecimal price; // por tonelada
    private BigDecimal stock;
    private boolean active;

    public Material(String name, BigDecimal price, BigDecimal stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.active = true;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
