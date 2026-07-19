package com.ana.quarryflow.core.application.usecases.vehicle;

import java.util.Optional;

import com.ana.quarryflow.core.domain.model.Vehicle;
import com.ana.quarryflow.core.domain.ports.in.vehicle.FindVehicleByPlateUseCase;
import com.ana.quarryflow.core.domain.ports.out.VehicleRepository;

public class FindVehicleByPlateService implements FindVehicleByPlateUseCase {

    private final VehicleRepository vehicleRepository;

    public FindVehicleByPlateService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Optional<Vehicle> execute(String plate) {
        return vehicleRepository.findByPlate(plate);
    }

}
