package com.ana.quarryflow.core.infrastructure.adapters.out.database.material;

import java.math.BigDecimal;
import java.util.UUID;

import com.ana.quarryflow.core.domain.model.Material;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "material")
public class MaterialEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false, length = 100, unique = true)
    private String name;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "stock", nullable = false, precision = 12, scale = 3)
    private BigDecimal stock;

    @Column(name = "active", nullable = false)
    private boolean active;

    public MaterialEntity() {
    }

    public MaterialEntity(UUID id, String name, BigDecimal price, BigDecimal stock, boolean active) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.active = active;
    }

    public static MaterialEntity fromDomain(Material material) {
        return new MaterialEntity(
            material.getId(),
            material.getName(),
            material.getPrice(),
            material.getStock(),
            material.isActive()
        );
    }

    public Material toDomain() {
        Material material = new Material(this.name, this.price, this.stock);
        material.setId(this.id);
        material.setActive(this.active);
        return material;
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
