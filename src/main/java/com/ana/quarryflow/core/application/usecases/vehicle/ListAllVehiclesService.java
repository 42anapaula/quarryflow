package com.ana.quarryflow.core.application.usecases.vehicle;

import java.util.List;

import com.ana.quarryflow.core.domain.model.Vehicle;
import com.ana.quarryflow.core.domain.ports.in.vehicle.ListAllVehiclesUseCase;
import com.ana.quarryflow.core.domain.ports.out.VehicleRepository;

public class ListAllVehiclesService implements ListAllVehiclesUseCase {

    private final VehicleRepository vehicleRepository;

    public ListAllVehiclesService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> execute() {
        return vehicleRepository.findAll();
    }

}
