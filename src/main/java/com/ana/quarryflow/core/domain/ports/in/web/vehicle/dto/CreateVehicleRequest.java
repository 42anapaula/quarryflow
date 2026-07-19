package com.ana.quarryflow.core.domain.ports.in.web.vehicle.dto;

import java.math.BigDecimal;

import com.ana.quarryflow.core.domain.model.Vehicle;

public record CreateVehicleRequest(
    String plate,
    String model,
    BigDecimal tara,
    BigDecimal capacity,
    Boolean active
) {
    public Vehicle toDomain() {
        Vehicle vehicle = new Vehicle();
        vehicle.setPlate(this.plate);
        vehicle.setModel(this.model);
        vehicle.setTara(this.tara);
        vehicle.setCapacity(this.capacity);
        vehicle.setActive(this.active != null ? this.active : true);
        return vehicle;
    }

    public Vehicle toDomainForUpdate() {
        Vehicle vehicle = new Vehicle();
        vehicle.setPlate(this.plate);
        vehicle.setModel(this.model);
        vehicle.setTara(this.tara);
        vehicle.setCapacity(this.capacity);
        vehicle.setActive(this.active);
        return vehicle;
    }
}