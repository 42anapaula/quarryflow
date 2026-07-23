package com.ana.quarryflow.core.domain.ports.in.web.material.dto;

import java.math.BigDecimal;

import com.ana.quarryflow.core.domain.model.Material;

public record CreateMaterialRequest(
    String name,
    BigDecimal price,
    BigDecimal stock,
    Boolean active
) {
    public Material toDomain() {
        Material material = new Material(name, price, stock);
        material.setActive(active != null ? active : true);
        return material;
    }
}
