package com.ana.quarryflow.core.domain.ports.in.contract;

import java.util.Optional;
import java.util.UUID;

import com.ana.quarryflow.core.domain.model.Contract;

public interface FindContractByIdUseCase {

    Optional<Contract> execute(UUID id);
}
