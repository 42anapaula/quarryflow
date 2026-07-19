package com.ana.quarryflow.core.infrastructure.adapters.out.database.vehicle;

import java.math.BigDecimal;
import java.util.UUID;

import com.ana.quarryflow.core.domain.model.Vehicle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle")
public class VehicleEntity {

    @Id
    @Column(name = "plate", length = 7)
    private String plate;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "tara", nullable = false, precision = 10, scale = 2)
    private BigDecimal tara;

    @Column(name = "capacity", nullable = false, precision = 5, scale = 2)
    private BigDecimal capacity;

    @Column(name = "active", nullable = false)
    private boolean active;

    public VehicleEntity() {
    }

    public VehicleEntity(String plate, String model, BigDecimal tara, BigDecimal capacity, boolean active) {
        this.plate = plate;
        this.model = model;
        this.tara = tara;
        this.capacity = capacity;
        this.active = active;
    }

    public static VehicleEntity fromDomain(Vehicle vehicle) {
        return new VehicleEntity(
            vehicle.getPlate(),
            vehicle.getModel(),
            vehicle.getTara(),
            vehicle.getCapacity(),
            Boolean.TRUE.equals(vehicle.getActive())
        );
    }

    public Vehicle toDomain() {
        Vehicle vehicle = new Vehicle();
        vehicle.setPlate(this.plate);
        vehicle.setModel(this.model);
        vehicle.setTara(this.tara);
        vehicle.setCapacity(this.capacity);
        vehicle.setActive(this.active);
        return vehicle;
    }

    public String getPlate() { return plate; }
    public void setPlate(String plate) { this.plate = plate; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public BigDecimal getTara() { return tara; }
    public void setTara(BigDecimal tara) { this.tara = tara; }

    public BigDecimal getCapacity() { return capacity; }
    public void setCapacity(BigDecimal capacity) { this.capacity = capacity; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

}
