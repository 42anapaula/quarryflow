package com.ana.quarryflow.core.application.usecases.material;

import java.util.List;

import com.ana.quarryflow.core.domain.model.Material;
import com.ana.quarryflow.core.domain.ports.in.material.ListAllMaterialsUseCase;
import com.ana.quarryflow.core.domain.ports.out.MaterialRepository;

public class ListAllMaterialsService implements ListAllMaterialsUseCase {

    private final MaterialRepository materialRepository;

    public ListAllMaterialsService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public List<Material> execute() {
        return materialRepository.findAll();
    }

}
