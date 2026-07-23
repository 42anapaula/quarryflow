package com.ana.quarryflow.core.application.usecases.client;

import java.util.List;

import com.ana.quarryflow.core.domain.model.Client;
import com.ana.quarryflow.core.domain.ports.in.client.ListAllClientsUseCase;
import com.ana.quarryflow.core.domain.ports.out.ClientRepository;

public class ListAllClientsService implements ListAllClientsUseCase {

    private final ClientRepository clientRepository;

    public ListAllClientsService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> execute() {
        return clientRepository.findAll();
    }

}
