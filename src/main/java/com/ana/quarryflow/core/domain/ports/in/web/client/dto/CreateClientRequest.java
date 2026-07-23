package com.ana.quarryflow.core.domain.ports.in.web.client.dto;

import java.time.LocalDateTime;

import com.ana.quarryflow.core.domain.model.Client;

public record CreateClientRequest(
    String document,
    String socialName,
    Boolean active
) {
    public Client toDomain() {
        Client client = new Client(
            document,
            socialName,
            LocalDateTime.now()
        );
        client.setActive(this.active != null ? this.active : true);
        return client;
    }
}
