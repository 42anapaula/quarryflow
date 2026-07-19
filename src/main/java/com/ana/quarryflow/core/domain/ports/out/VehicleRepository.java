package com.ana.quarryflow.core.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.ana.quarryflow.core.domain.model.Vehicle;
public interface VehicleRepository {
    Vehicle save(Vehicle vehicle);
    Optional<Vehicle> findByPlate(String plate);
    List<Vehicle> findAll();
}
