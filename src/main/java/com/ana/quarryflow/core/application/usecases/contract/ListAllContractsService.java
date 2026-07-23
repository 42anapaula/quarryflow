package com.ana.quarryflow.core.application.usecases.contract;

import java.util.List;

import com.ana.quarryflow.core.domain.model.Contract;
import com.ana.quarryflow.core.domain.ports.in.contract.ListAllContractsUseCase;
import com.ana.quarryflow.core.domain.ports.out.ContractRepository;

public class ListAllContractsService implements ListAllContractsUseCase {

    private final ContractRepository contractRepository;

    public ListAllContractsService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public List<Contract> execute() {
        return contractRepository.findAll();
    }

}
