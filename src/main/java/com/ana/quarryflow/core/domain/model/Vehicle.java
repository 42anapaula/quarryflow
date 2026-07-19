package com.ana.quarryflow.core.domain.model;

import java.math.BigDecimal;

public class Vehicle {

    private String plate;
    private String model;
    private BigDecimal tara;
    private BigDecimal capacity;
    private Boolean active;

    public Vehicle() {
    }

    public Vehicle(String plate, String model, BigDecimal tara, BigDecimal capacity) {
        this.plate = plate;
        this.model = model;
        this.tara = tara;
        this.capacity = capacity;
        this.active = true;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getTara() {
        return tara;
    }

    public void setTara(BigDecimal tara) {
        this.tara = tara;
    }

    public BigDecimal getCapacity() {
        return capacity;
    }

    public void setCapacity(BigDecimal capacity) {
        this.capacity = capacity;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void normalizePlate() {
        if (this.plate != null) {
            this.plate = this.plate
                            .trim()
                            .toUpperCase()
                            .replace("-", "")
                            .replaceAll("\\s+", "");
        }
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "plate='" + plate + '\'' +
                ", model='" + model + '\'' +
                ", tara=" + tara +
                ", capacity=" + capacity +
                ", active=" + active +
                '}';
    }
}
