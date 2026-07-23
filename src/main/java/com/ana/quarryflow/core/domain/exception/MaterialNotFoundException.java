package com.ana.quarryflow.core.domain.exception;

public class MaterialNotFoundException extends RuntimeException {

    public MaterialNotFoundException(String materialId) {
        super("Material with ID " + materialId + " was not found.");
    }

}
