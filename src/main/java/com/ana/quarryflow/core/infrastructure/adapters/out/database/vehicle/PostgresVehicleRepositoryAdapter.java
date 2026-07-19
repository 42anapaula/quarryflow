package com.ana.quarryflow.core.infrastructure.adapters.out.database.vehicle;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ana.quarryflow.core.domain.model.Vehicle;
import com.ana.quarryflow.core.domain.ports.out.VehicleRepository;

public class PostgresVehicleRepositoryAdapter implements VehicleRepository {

    private final SpringDataVehicleRepository jpaRepository;

    public PostgresVehicleRepositoryAdapter(SpringDataVehicleRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        VehicleEntity entityToSave = VehicleEntity.fromDomain(vehicle);
        VehicleEntity savedEntity = jpaRepository.save(entityToSave);
        return savedEntity.toDomain();
    }

    @Override
    public Optional<Vehicle> findByPlate(String plate) {
        return jpaRepository.findById(plate)
                            .map(VehicleEntity::toDomain);
    }

    @Override
    public List<Vehicle> findAll() {
        return jpaRepository.findAll().stream()
                            .map(VehicleEntity::toDomain)
                            .collect(Collectors.toList());
    }
    
}
