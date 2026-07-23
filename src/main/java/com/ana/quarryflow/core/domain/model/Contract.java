package com.ana.quarryflow.core.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Contract {

    private UUID id;
    private Client client;
    private BigDecimal creditLimit;
    private BigDecimal availableBalance;
    private boolean active;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Contract() {
    }

    public Contract(Client client, BigDecimal creditLimit, BigDecimal availableBalance, LocalDateTime startDate, LocalDateTime endDate) {
        this.client = client;
        this.creditLimit = creditLimit;
        this.availableBalance = availableBalance;
        this.active = true;
        this.startDate = startDate;
        this.endDate = endDate;
    }

        public Contract(Client client, BigDecimal creditLimit, BigDecimal availableBalance, boolean active, LocalDateTime startDate, LocalDateTime endDate) {
        this.client = client;
        this.creditLimit = creditLimit;
        this.availableBalance = availableBalance;
        this.active = active;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
