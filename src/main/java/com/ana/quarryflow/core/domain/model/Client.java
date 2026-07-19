package com.ana.quarryflow.core.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Client {

    private UUID id;
    private String document;
    private String socialName;
    private boolean active;
    private LocalDateTime createdAt;

    public Client(String document, String socialName, LocalDateTime createdAt) {
        this(document, socialName, true, createdAt);
    }

    public Client(String document, String socialName, boolean active, LocalDateTime createdAt) {
        this.document = document;
        this.socialName = socialName;
        this.active = active;
        this.createdAt = createdAt;
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
