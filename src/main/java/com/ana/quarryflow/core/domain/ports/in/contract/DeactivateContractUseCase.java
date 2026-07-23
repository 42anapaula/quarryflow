package com.ana.quarryflow.core.domain.ports.in.contract;

import java.util.UUID;

public interface DeactivateContractUseCase {

    void execute(UUID id);
}
