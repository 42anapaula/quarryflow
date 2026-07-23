package com.ana.quarryflow.core.domain.ports.in.web.contract.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.ana.quarryflow.core.domain.model.Client;
import com.ana.quarryflow.core.domain.model.Contract;

public record CreateContractRequest(
    String clientId,
    BigDecimal creditLimit,
    BigDecimal availableBalance,
    Boolean active,
    LocalDateTime startDate,
    LocalDateTime endDate
) {
    public Contract toDomain(Client client) {
        Contract contract = new Contract();
        contract.setClient(client);
        contract.setCreditLimit(creditLimit);
        contract.setAvailableBalance(availableBalance);
        contract.setActive(active != null ? active : true);
        contract.setStartDate(startDate);
        contract.setEndDate(endDate);
        return contract;
    }
}
