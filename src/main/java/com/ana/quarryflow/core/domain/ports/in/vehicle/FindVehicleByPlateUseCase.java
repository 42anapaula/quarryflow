package com.ana.quarryflow.core.domain.ports.in.vehicle;

import java.util.Optional;

import com.ana.quarryflow.core.domain.model.Vehicle;

public interface FindVehicleByPlateUseCase {

    Optional<Vehicle> execute(String plate);
}
