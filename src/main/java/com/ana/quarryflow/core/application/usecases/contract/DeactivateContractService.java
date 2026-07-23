package com.ana.quarryflow.core.application.usecases.contract;

import java.util.UUID;

import com.ana.quarryflow.core.domain.exception.ContractNotFoundException;
import com.ana.quarryflow.core.domain.model.Contract;
import com.ana.quarryflow.core.domain.ports.in.contract.DeactivateContractUseCase;
import com.ana.quarryflow.core.domain.ports.out.ContractRepository;

public class DeactivateContractService implements DeactivateContractUseCase {

    private final ContractRepository contractRepository;

    public DeactivateContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public void execute(UUID id) {
        Contract contract = contractRepository.findById(id)
                .orElseThrow(() -> new ContractNotFoundException(id.toString()));
        contract.setActive(false);
        contractRepository.save(contract);
    }

}
