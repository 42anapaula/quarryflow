package com.ana.quarryflow.core.application.usecases.contract;

import java.util.Optional;
import java.util.UUID;

import com.ana.quarryflow.core.domain.model.Contract;
import com.ana.quarryflow.core.domain.ports.in.contract.FindContractByIdUseCase;
import com.ana.quarryflow.core.domain.ports.out.ContractRepository;

public class FindContractByIdService implements FindContractByIdUseCase {

    private final ContractRepository contractRepository;

    public FindContractByIdService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public Optional<Contract> execute(UUID id) {
        return contractRepository.findById(id);
    }

}
