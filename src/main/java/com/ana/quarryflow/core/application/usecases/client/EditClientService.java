package com.ana.quarryflow.core.application.usecases.client;

import java.util.UUID;

import com.ana.quarryflow.core.domain.model.Client;
import com.ana.quarryflow.core.domain.ports.in.client.EditClientUseCase;
import com.ana.quarryflow.core.domain.ports.out.ClientRepository;

public class EditClientService implements EditClientUseCase {

    private final ClientRepository clientRepository;

    public EditClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client execute(UUID id, Client client) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client not found with id: " + id));
        
        if (client.getDocument() != null && !client.getDocument().equals(existingClient.getDocument())) {
            if (clientRepository.findByDocument(client.getDocument()).isPresent()) {
                throw new IllegalArgumentException("Client with document " + client.getDocument() + " already exists.");
            }
            existingClient.setDocument(client.getDocument());
        }
        
        if (client.getSocialName() != null) {
            existingClient.setSocialName(client.getSocialName());
        }
        
        if (client.isActive() != existingClient.isActive()) {
            existingClient.setActive(client.isActive());
        }
        
        return clientRepository.save(existingClient);
    }

}
