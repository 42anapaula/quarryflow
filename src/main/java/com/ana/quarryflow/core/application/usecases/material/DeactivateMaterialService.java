package com.ana.quarryflow.core.application.usecases.material;

import java.util.UUID;

import com.ana.quarryflow.core.domain.exception.MaterialNotFoundException;
import com.ana.quarryflow.core.domain.model.Material;
import com.ana.quarryflow.core.domain.ports.in.material.DeactivateMaterialUseCase;
import com.ana.quarryflow.core.domain.ports.out.MaterialRepository;

public class DeactivateMaterialService implements DeactivateMaterialUseCase {

    private final MaterialRepository materialRepository;

    public DeactivateMaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public void execute(UUID id) {
        Material material = materialRepository.findById(id)
                .orElseThrow(() -> new MaterialNotFoundException(id.toString()));
        material.setActive(false);
        materialRepository.save(material);
    }

}
