package com.ana.quarryflow.core.application.usecases.contract;

import java.util.UUID;

import com.ana.quarryflow.core.domain.model.Contract;
import com.ana.quarryflow.core.domain.ports.in.contract.EditContractUseCase;
import com.ana.quarryflow.core.domain.ports.out.ContractRepository;

public class EditContractService implements EditContractUseCase {

    private final ContractRepository contractRepository;

    public EditContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public Contract execute(UUID id, Contract contract) {
        Contract existingContract = contractRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Contract not found with id: " + id));
        
        if (contract.getCreditLimit() != null) {
            existingContract.setCreditLimit(contract.getCreditLimit());
        }
        
        if (contract.getAvailableBalance() != null) {
            existingContract.setAvailableBalance(contract.getAvailableBalance());
        }
        
        if (contract.getStartDate() != null) {
            existingContract.setStartDate(contract.getStartDate());
        }
        
        if (contract.getEndDate() != null) {
            existingContract.setEndDate(contract.getEndDate());
        }
        
        if (contract.isActive() != existingContract.isActive()) {
            existingContract.setActive(contract.isActive());
        }
        
        return contractRepository.save(existingContract);
    }

}
