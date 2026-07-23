package com.ana.quarryflow.core.domain.ports.in.contract;

import java.util.UUID;

import com.ana.quarryflow.core.domain.model.Contract;

public interface EditContractUseCase {

    Contract execute(UUID id, Contract contract);

}
