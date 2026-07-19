package com.ana.quarryflow.core.application.usecases.vehicle;

import com.ana.quarryflow.core.domain.model.Vehicle;
import com.ana.quarryflow.core.domain.ports.in.vehicle.RegisterVehicleUseCase;
import com.ana.quarryflow.core.domain.ports.out.VehicleRepository;

public class RegisterVehicleService implements RegisterVehicleUseCase {

    private final VehicleRepository vehicleRepository;

    public RegisterVehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle execute(Vehicle vehicle) {
        if (vehicleRepository.findByPlate(vehicle.getPlate()).isPresent()) {
            throw new IllegalArgumentException("Vehicle with plate " + vehicle.getPlate() + " already exists.");
        }

        vehicle.normalizePlate(); 

        return vehicleRepository.save(vehicle); 
    }
}
