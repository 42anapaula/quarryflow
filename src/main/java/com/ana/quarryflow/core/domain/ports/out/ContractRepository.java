package com.ana.quarryflow.core.domain.ports.out;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ana.quarryflow.core.domain.model.Contract;

public interface ContractRepository {

    Contract save(Contract contract);

    Optional<Contract> findById(UUID id);

    List<Contract> findAll();
}
