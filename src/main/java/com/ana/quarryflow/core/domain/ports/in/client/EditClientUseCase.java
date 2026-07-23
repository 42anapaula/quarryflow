package com.ana.quarryflow.core.domain.ports.in.client;

import java.util.UUID;

import com.ana.quarryflow.core.domain.model.Client;

public interface EditClientUseCase {

    Client execute(UUID id, Client client);

}
