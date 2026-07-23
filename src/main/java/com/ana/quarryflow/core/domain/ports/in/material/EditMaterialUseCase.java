package com.ana.quarryflow.core.domain.ports.in.material;

import java.util.UUID;

import com.ana.quarryflow.core.domain.model.Material;

public interface EditMaterialUseCase {

    Material execute(UUID id, Material material);

}
