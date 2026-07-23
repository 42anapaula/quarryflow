package com.ana.quarryflow.core.domain.ports.in.client;

import java.util.List;

import com.ana.quarryflow.core.domain.model.Client;

public interface ListAllClientsUseCase {

    List<Client> execute();

}
