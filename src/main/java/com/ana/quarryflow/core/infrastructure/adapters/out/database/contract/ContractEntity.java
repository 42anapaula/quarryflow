package com.ana.quarryflow.core.infrastructure.adapters.out.database.contract;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.ana.quarryflow.core.domain.model.Contract;
import com.ana.quarryflow.core.domain.model.Client;
import com.ana.quarryflow.core.infrastructure.adapters.out.database.client.ClientEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contract")
public class ContractEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity client;

    @Column(name = "credit_limit", nullable = false, precision = 12, scale = 2)
    private BigDecimal creditLimit;

    @Column(name = "available_balance", nullable = false, precision = 12, scale = 2)
    private BigDecimal availableBalance;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    public ContractEntity() {
    }

    public ContractEntity(UUID id, ClientEntity client, BigDecimal creditLimit, BigDecimal availableBalance, boolean active, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.client = client;
        this.creditLimit = creditLimit;
        this.availableBalance = availableBalance;
        this.active = active;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static ContractEntity fromDomain(Contract contract, ClientEntity clientEntity) {
        return new ContractEntity(
            contract.getId(),
            clientEntity,
            contract.getCreditLimit(),
            contract.getAvailableBalance(),
            contract.isActive(),
            contract.getStartDate(),
            contract.getEndDate()
        );
    }

    public Contract toDomain() {
        Contract contract = new Contract();
        contract.setId(this.id);
        contract.setClient(this.client != null ? this.client.toDomain() : null);
        contract.setCreditLimit(this.creditLimit);
        contract.setAvailableBalance(this.availableBalance);
        contract.setActive(this.active);
        contract.setStartDate(this.startDate);
        contract.setEndDate(this.endDate);
        return contract;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
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
