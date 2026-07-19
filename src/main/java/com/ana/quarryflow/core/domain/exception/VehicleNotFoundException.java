package com.ana.quarryflow.core.domain.exception;

public class VehicleNotFoundException extends RuntimeException {

    public VehicleNotFoundException(String plate) {
        super("Vehicle with plate " + plate + " was not found.");
    }

}
