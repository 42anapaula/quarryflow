package com.ana.quarryflow.core.domain.exception;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(String clientId) {
        super("Client with ID " + clientId + " was not found.");
    }

}
