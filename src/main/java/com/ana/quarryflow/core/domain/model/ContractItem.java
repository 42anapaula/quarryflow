package com.ana.quarryflow.core.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class ContractItem {
    
    private UUID id;
    private Contract contract;
    private Material material;
    private BigDecimal agreedPrice;

    public ContractItem(Contract contract, Material material, BigDecimal agreedPrice) {
        this.contract = contract;
        this.material = material;
        this.agreedPrice = agreedPrice;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public BigDecimal getAgreedPrice() {
        return agreedPrice;
    }

    public void setAgreedPrice(BigDecimal agreedPrice) {
        this.agreedPrice = agreedPrice;
    }
}
