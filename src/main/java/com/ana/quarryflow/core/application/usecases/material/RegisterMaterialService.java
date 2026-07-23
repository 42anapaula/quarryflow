package com.ana.quarryflow.core.application.usecases.material;

import java.util.UUID;

import com.ana.quarryflow.core.domain.model.Material;
import com.ana.quarryflow.core.domain.ports.in.material.RegisterMaterialUseCase;
import com.ana.quarryflow.core.domain.ports.out.MaterialRepository;

public class RegisterMaterialService implements RegisterMaterialUseCase {

    private final MaterialRepository materialRepository;

    public RegisterMaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public Material execute(Material material) {
        if (materialRepository.findByName(material.getName()).isPresent()) {
            throw new IllegalArgumentException("Material with name " + material.getName() + " already exists.");
        }
        material.setId(UUID.randomUUID());
        material.setActive(material.isActive());
        return materialRepository.save(material);
    }
}
