package com.ana.quarryflow.core.infrastructure.adapters.out.database.material;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMaterialRepository extends JpaRepository<MaterialEntity, UUID> {
    Optional<MaterialEntity> findByName(String name);
}
