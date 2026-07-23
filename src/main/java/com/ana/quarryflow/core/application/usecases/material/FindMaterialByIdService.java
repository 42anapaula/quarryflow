package com.ana.quarryflow.core.application.usecases.material;

import java.util.Optional;
import java.util.UUID;

import com.ana.quarryflow.core.domain.model.Material;
import com.ana.quarryflow.core.domain.ports.in.material.FindMaterialByIdUseCase;
import com.ana.quarryflow.core.domain.ports.out.MaterialRepository;

public class FindMaterialByIdService implements FindMaterialByIdUseCase {

    private final MaterialRepository materialRepository;

    public FindMaterialByIdService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public Optional<Material> execute(UUID id) {
        return materialRepository.findById(id);
    }

}
