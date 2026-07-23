package com.ana.quarryflow.core.infrastructure.adapters.out.database.client;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataClientRepository extends JpaRepository<ClientEntity, UUID> {
    Optional<ClientEntity> findByDocument(String document);
}
