package com.ana.quarryflow.core.domain.ports.out;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ana.quarryflow.core.domain.model.Material;

public interface MaterialRepository {

    Material save(Material material);

    Optional<Material> findById(UUID id);

    Optional<Material> findByName(String name);

    List<Material> findAll();
}
