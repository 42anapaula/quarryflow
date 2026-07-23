package com.ana.quarryflow.core.application.usecases.client;

import java.util.Optional;
import java.util.UUID;

import com.ana.quarryflow.core.domain.model.Client;
import com.ana.quarryflow.core.domain.ports.in.client.FindClientByIdUseCase;
import com.ana.quarryflow.core.domain.ports.out.ClientRepository;

public class FindClientByIdService implements FindClientByIdUseCase {

    private final ClientRepository clientRepository;

    public FindClientByIdService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Client> execute(UUID id) {
        return clientRepository.findById(id);
    }

}
