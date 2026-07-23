package com.ana.quarryflow.core.infrastructure.adapters.out.database.client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.ana.quarryflow.core.domain.model.Client;
import com.ana.quarryflow.core.domain.ports.out.ClientRepository;

public class PostgresClientRepositoryAdapter implements ClientRepository {

    private final SpringDataClientRepository jpaRepository;

    public PostgresClientRepositoryAdapter(SpringDataClientRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Client save(Client client) {
        ClientEntity entityToSave = ClientEntity.fromDomain(client);
        ClientEntity savedEntity = jpaRepository.save(entityToSave);
        return savedEntity.toDomain();
    }

    @Override
    public Optional<Client> findById(UUID id) {
        return jpaRepository.findById(id).map(ClientEntity::toDomain);
    }

    @Override
    public Optional<Client> findByDocument(String document) {
        return jpaRepository.findByDocument(document).map(ClientEntity::toDomain);
    }

    @Override
    public List<Client> findAll() {
        return jpaRepository.findAll().stream()
                .map(ClientEntity::toDomain)
                .collect(Collectors.toList());
    }
}
