package com.ana.quarryflow.core.domain.exception;

public class ContractNotFoundException extends RuntimeException {

    public ContractNotFoundException(String contractId) {
        super("Contract with ID " + contractId + " was not found.");
    }

}
