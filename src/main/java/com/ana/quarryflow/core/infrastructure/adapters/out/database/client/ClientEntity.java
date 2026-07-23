package com.ana.quarryflow.core.infrastructure.adapters.out.database.client;

import java.time.LocalDateTime;
import java.util.UUID;

import com.ana.quarryflow.core.domain.model.Client;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class ClientEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "document", nullable = false, length = 14, unique = true)
    private String document;

    @Column(name = "social_name", nullable = false)
    private String socialName;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public ClientEntity() {
    }

    public ClientEntity(UUID id, String document, String socialName, boolean active, LocalDateTime createdAt) {
        this.id = id;
        this.document = document;
        this.socialName = socialName;
        this.active = active;
        this.createdAt = createdAt;
    }

    public static ClientEntity fromDomain(Client client) {
        return new ClientEntity(
            client.getId(),
            client.getDocument(),
            client.getSocialName(),
            client.isActive(),
            client.getCreatedAt() != null ? client.getCreatedAt() : LocalDateTime.now()
        );
    }

    public Client toDomain() {
        Client client = new Client();
        client.setId(this.id);
        client.setDocument(this.document);
        client.setSocialName(this.socialName);
        client.setActive(this.active);
        client.setCreatedAt(this.createdAt);
        return client;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getSocialName() {
        return socialName;
    }

    public void setSocialName(String socialName) {
        this.socialName = socialName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
