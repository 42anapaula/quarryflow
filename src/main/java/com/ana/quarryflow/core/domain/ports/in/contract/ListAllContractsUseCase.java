package com.ana.quarryflow.core.domain.ports.in.contract;

import java.util.List;

import com.ana.quarryflow.core.domain.model.Contract;

public interface ListAllContractsUseCase {

    List<Contract> execute();

}
