package com.ana.quarryflow.core.domain.ports.in.vehicle;

import com.ana.quarryflow.core.domain.model.Vehicle;

public interface EditVehicleUseCase {

    Vehicle execute(String plate, Vehicle vehicle);

}
