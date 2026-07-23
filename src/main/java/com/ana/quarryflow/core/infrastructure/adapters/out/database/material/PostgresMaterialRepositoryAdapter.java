package com.ana.quarryflow.core.infrastructure.adapters.out.database.material;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.ana.quarryflow.core.domain.model.Material;
import com.ana.quarryflow.core.domain.ports.out.MaterialRepository;

public class PostgresMaterialRepositoryAdapter implements MaterialRepository {

    private final SpringDataMaterialRepository jpaRepository;

    public PostgresMaterialRepositoryAdapter(SpringDataMaterialRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Material save(Material material) {
        MaterialEntity entityToSave = MaterialEntity.fromDomain(material);
        MaterialEntity savedEntity = jpaRepository.save(entityToSave);
        return savedEntity.toDomain();
    }

    @Override
    public Optional<Material> findById(UUID id) {
        return jpaRepository.findById(id).map(MaterialEntity::toDomain);
    }

    @Override
    public Optional<Material> findByName(String name) {
        return jpaRepository.findByName(name).map(MaterialEntity::toDomain);
    }

    @Override
    public List<Material> findAll() {
        return jpaRepository.findAll().stream()
                .map(MaterialEntity::toDomain)
                .collect(Collectors.toList());
    }
}
