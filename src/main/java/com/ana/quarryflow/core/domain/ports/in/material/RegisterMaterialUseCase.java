package com.ana.quarryflow.core.domain.ports.in.material;

import com.ana.quarryflow.core.domain.model.Material;

public interface RegisterMaterialUseCase {

    Material execute(Material material);
}
