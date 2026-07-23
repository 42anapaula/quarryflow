package com.ana.quarryflow.core.domain.ports.in.client;

import java.util.Optional;
import java.util.UUID;

import com.ana.quarryflow.core.domain.model.Client;

public interface FindClientByIdUseCase {

    Optional<Client> execute(UUID id);
}
