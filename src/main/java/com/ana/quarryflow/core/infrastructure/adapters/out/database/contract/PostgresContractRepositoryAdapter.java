package com.ana.quarryflow.core.infrastructure.adapters.out.database.contract;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.ana.quarryflow.core.domain.model.Contract;
import com.ana.quarryflow.core.domain.ports.out.ContractRepository;
import com.ana.quarryflow.core.infrastructure.adapters.out.database.client.ClientEntity;
import com.ana.quarryflow.core.infrastructure.adapters.out.database.client.SpringDataClientRepository;

public class PostgresContractRepositoryAdapter implements ContractRepository {

    private final SpringDataContractRepository jpaRepository;
    private final SpringDataClientRepository clientJpaRepository;

    public PostgresContractRepositoryAdapter(SpringDataContractRepository jpaRepository,
            SpringDataClientRepository clientJpaRepository) {
        this.jpaRepository = jpaRepository;
        this.clientJpaRepository = clientJpaRepository;
    }

    @Override
    public Contract save(Contract contract) {
        ClientEntity clientEntity = null;
        if (contract.getClient() != null) {
            clientEntity = clientJpaRepository.findById(contract.getClient().getId())
                    .orElseGet(() -> clientJpaRepository.save(ClientEntity.fromDomain(contract.getClient())));
        }

        ContractEntity entityToSave = ContractEntity.fromDomain(contract, clientEntity);
        ContractEntity savedEntity = jpaRepository.save(entityToSave);
        return savedEntity.toDomain();
    }

    @Override
    public Optional<Contract> findById(UUID id) {
        return jpaRepository.findById(id).map(ContractEntity::toDomain);
    }

    @Override
    public List<Contract> findAll() {
        return jpaRepository.findAll().stream()
                .map(ContractEntity::toDomain)
                .collect(Collectors.toList());
    }
}
