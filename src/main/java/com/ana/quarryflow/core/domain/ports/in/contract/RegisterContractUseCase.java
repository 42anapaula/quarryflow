package com.ana.quarryflow.core.domain.ports.in.contract;

import com.ana.quarryflow.core.domain.model.Contract;

public interface RegisterContractUseCase {

    Contract execute(Contract contract);
}
