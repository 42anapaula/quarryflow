package com.ana.quarryflow.core.application.usecases.client;

import java.util.UUID;

import com.ana.quarryflow.core.domain.exception.ClientNotFoundException;
import com.ana.quarryflow.core.domain.model.Client;
import com.ana.quarryflow.core.domain.ports.in.client.DeactivateClientUseCase;
import com.ana.quarryflow.core.domain.ports.out.ClientRepository;

public class DeactivateClientService implements DeactivateClientUseCase {

    private final ClientRepository clientRepository;

    public DeactivateClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void execute(UUID id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id.toString()));
        client.setActive(false);
        clientRepository.save(client);
    }

}
