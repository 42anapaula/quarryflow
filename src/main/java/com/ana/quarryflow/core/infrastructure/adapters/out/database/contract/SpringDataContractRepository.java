package com.ana.quarryflow.core.infrastructure.adapters.out.database.contract;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataContractRepository extends JpaRepository<ContractEntity, UUID> {
}
