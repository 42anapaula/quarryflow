package com.ana.quarryflow.core.application.usecases.vehicle;

import com.ana.quarryflow.core.domain.exception.VehicleNotFoundException;
import com.ana.quarryflow.core.domain.model.Vehicle;
import com.ana.quarryflow.core.domain.ports.in.vehicle.EditVehicleUseCase;
import com.ana.quarryflow.core.domain.ports.out.VehicleRepository;

public class EditVehicleService implements EditVehicleUseCase {

    private final VehicleRepository vehicleRepository;

    public EditVehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle execute(String plate,Vehicle vehicle) {
        Vehicle existingVehicle = vehicleRepository.findByPlate(plate)
                .orElseThrow(() -> new VehicleNotFoundException(plate));
        vehicle.setPlate(plate);
        if (vehicle.getActive() == null) {
            vehicle.setActive(existingVehicle.getActive());
        }
        return vehicleRepository.save(vehicle);
    }

}
