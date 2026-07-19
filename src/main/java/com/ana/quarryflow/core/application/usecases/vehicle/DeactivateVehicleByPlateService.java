package com.ana.quarryflow.core.application.usecases.vehicle;

import com.ana.quarryflow.core.domain.exception.VehicleNotFoundException;
import com.ana.quarryflow.core.domain.model.Vehicle;
import com.ana.quarryflow.core.domain.ports.in.vehicle.DeactivateVehicleByPlateUseCase;
import com.ana.quarryflow.core.domain.ports.out.VehicleRepository;

public class DeactivateVehicleByPlateService implements DeactivateVehicleByPlateUseCase {

    private final VehicleRepository vehicleRepository;

    public DeactivateVehicleByPlateService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void execute(String plate) {
        Vehicle vehicle = vehicleRepository.findByPlate(plate)
                .orElseThrow(() -> new VehicleNotFoundException(plate));
        vehicle.setActive(false);
        vehicleRepository.save(vehicle);
    }

}
