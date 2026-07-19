package com.ana.quarryflow.core.domain.ports.in.vehicle;

import java.util.List;

import com.ana.quarryflow.core.domain.model.Vehicle;

public interface ListAllVehiclesUseCase {

    List<Vehicle> execute();

}
