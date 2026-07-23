package com.ana.quarryflow.core.domain.ports.in.client;

import com.ana.quarryflow.core.domain.model.Client;

public interface RegisterClientUseCase {

    Client execute(Client client);
}
