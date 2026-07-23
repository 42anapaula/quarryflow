package com.ana.quarryflow.core.application.usecases.contract;

import java.util.UUID;

import com.ana.quarryflow.core.domain.model.Contract;
import com.ana.quarryflow.core.domain.ports.in.contract.RegisterContractUseCase;
import com.ana.quarryflow.core.domain.ports.out.ContractRepository;

public class RegisterContractService implements RegisterContractUseCase {

    private final ContractRepository contractRepository;

    public RegisterContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public Contract execute(Contract contract) {
        contract.setId(UUID.randomUUID());
        contract.setActive(contract.isActive());
        return contractRepository.save(contract);
    }
}
