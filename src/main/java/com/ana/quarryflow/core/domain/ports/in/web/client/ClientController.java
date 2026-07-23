package com.ana.quarryflow.core.domain.ports.in.web.client;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ana.quarryflow.core.domain.model.Client;
import com.ana.quarryflow.core.domain.ports.in.client.DeactivateClientUseCase;
import com.ana.quarryflow.core.domain.ports.in.client.EditClientUseCase;
import com.ana.quarryflow.core.domain.ports.in.client.FindClientByIdUseCase;
import com.ana.quarryflow.core.domain.ports.in.client.ListAllClientsUseCase;
import com.ana.quarryflow.core.domain.ports.in.client.RegisterClientUseCase;
import com.ana.quarryflow.core.domain.ports.in.web.client.dto.CreateClientRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    private final RegisterClientUseCase registerClientUseCase;
    private final ListAllClientsUseCase listAllClientsUseCase;
    private final FindClientByIdUseCase findClientByIdUseCase;
    private final EditClientUseCase editClientUseCase;
    private final DeactivateClientUseCase deactivateClientUseCase;

    public ClientController(RegisterClientUseCase registerClientUseCase,
            ListAllClientsUseCase listAllClientsUseCase,
            FindClientByIdUseCase findClientByIdUseCase,
            EditClientUseCase editClientUseCase,
            DeactivateClientUseCase deactivateClientUseCase) {
        this.registerClientUseCase = registerClientUseCase;
        this.listAllClientsUseCase = listAllClientsUseCase;
        this.findClientByIdUseCase = findClientByIdUseCase;
        this.editClientUseCase = editClientUseCase;
        this.deactivateClientUseCase = deactivateClientUseCase;
    }

    @PostMapping("")
    public ResponseEntity<Client> create(@RequestBody CreateClientRequest request) {
        Client client = request.toDomain();
        Client savedClient = registerClientUseCase.execute(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }

    @GetMapping("")
    public ResponseEntity<List<Client>> findAll() {
        List<Client> clients = listAllClientsUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable UUID id) {
        return findClientByIdUseCase.execute(id)
                .map(client -> ResponseEntity.status(HttpStatus.OK).body(client))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable UUID id, @RequestBody CreateClientRequest request) {
        Client clientDomain = request.toDomain();
        Client updatedClient = editClientUseCase.execute(id, clientDomain);
        return ResponseEntity.status(HttpStatus.OK).body(updatedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivate(@PathVariable UUID id) {
        deactivateClientUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
