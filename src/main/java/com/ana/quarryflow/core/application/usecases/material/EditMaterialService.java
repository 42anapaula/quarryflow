package com.ana.quarryflow.core.application.usecases.material;

import java.util.UUID;

import com.ana.quarryflow.core.domain.model.Material;
import com.ana.quarryflow.core.domain.ports.in.material.EditMaterialUseCase;
import com.ana.quarryflow.core.domain.ports.out.MaterialRepository;

public class EditMaterialService implements EditMaterialUseCase {

    private final MaterialRepository materialRepository;

    public EditMaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public Material execute(UUID id, Material material) {
        Material existingMaterial = materialRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Material not found with id: " + id));
        
        if (material.getName() != null && !material.getName().equals(existingMaterial.getName())) {
            if (materialRepository.findByName(material.getName()).isPresent()) {
                throw new IllegalArgumentException("Material with name " + material.getName() + " already exists.");
            }
            existingMaterial.setName(material.getName());
        }
        
        if (material.getPrice() != null) {
            existingMaterial.setPrice(material.getPrice());
        }
        
        if (material.getStock() != null) {
            existingMaterial.setStock(material.getStock());
        }
        
        if (material.isActive() != existingMaterial.isActive()) {
            existingMaterial.setActive(material.isActive());
        }
        
        return materialRepository.save(existingMaterial);
    }

}
