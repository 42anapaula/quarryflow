package com.ana.quarryflow.core.domain.ports.out;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ana.quarryflow.core.domain.model.Client;

public interface ClientRepository {

    Client save(Client client);

    Optional<Client> findById(UUID id);

    Optional<Client> findByDocument(String document);

    List<Client> findAll();
}
