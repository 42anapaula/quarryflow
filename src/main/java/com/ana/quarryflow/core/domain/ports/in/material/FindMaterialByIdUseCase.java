package com.ana.quarryflow.core.domain.ports.in.material;

import java.util.Optional;
import java.util.UUID;

import com.ana.quarryflow.core.domain.model.Material;

public interface FindMaterialByIdUseCase {

    Optional<Material> execute(UUID id);
}
