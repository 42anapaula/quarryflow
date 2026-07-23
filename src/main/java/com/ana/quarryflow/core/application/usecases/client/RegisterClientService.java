package com.ana.quarryflow.core.application.usecases.client;

import com.ana.quarryflow.core.domain.model.Client;
import com.ana.quarryflow.core.domain.ports.in.client.RegisterClientUseCase;
import com.ana.quarryflow.core.domain.ports.out.ClientRepository;

public class RegisterClientService implements RegisterClientUseCase {

    private final ClientRepository clientRepository;

    public RegisterClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client execute(Client client) {
        if (clientRepository.findByDocument(client.getDocument()).isPresent()) {
            throw new IllegalArgumentException("Client with document " + client.getDocument() + " already exists.");
        }
        client.setId(java.util.UUID.randomUUID());
        client.setCreatedAt(java.time.LocalDateTime.now());
        client.setActive(client.isActive());
        return clientRepository.save(client);
    }
}
