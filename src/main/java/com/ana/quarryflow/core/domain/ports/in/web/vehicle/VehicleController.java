package com.ana.quarryflow.core.domain.ports.in.web.vehicle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ana.quarryflow.core.domain.model.Vehicle;
import com.ana.quarryflow.core.domain.ports.in.vehicle.DeactivateVehicleByPlateUseCase;
import com.ana.quarryflow.core.domain.ports.in.vehicle.EditVehicleUseCase;
import com.ana.quarryflow.core.domain.ports.in.vehicle.FindVehicleByPlateUseCase;
import com.ana.quarryflow.core.domain.ports.in.vehicle.ListAllVehiclesUseCase;
import com.ana.quarryflow.core.domain.ports.in.vehicle.RegisterVehicleUseCase;
import com.ana.quarryflow.core.domain.ports.in.web.vehicle.dto.CreateVehicleRequest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

    private final FindVehicleByPlateUseCase findVehicleByPlateUseCase;
    private final RegisterVehicleUseCase registerVehicleUseCase;
    private final ListAllVehiclesUseCase listAllVehiclesUseCase;
    private final DeactivateVehicleByPlateUseCase deactivateVehicleByPlateUseCase;
    private final EditVehicleUseCase editVehicleUseCase;

    public VehicleController(RegisterVehicleUseCase registerVehicleUseCase,
            ListAllVehiclesUseCase listAllVehiclesUseCase, 
            FindVehicleByPlateUseCase findVehicleByPlateUseCase,
            DeactivateVehicleByPlateUseCase deactivateVehicleByPlateUseCase,
            EditVehicleUseCase editVehicleUseCase) {
        this.registerVehicleUseCase = registerVehicleUseCase;
        this.listAllVehiclesUseCase = listAllVehiclesUseCase;
        this.findVehicleByPlateUseCase = findVehicleByPlateUseCase;
        this.deactivateVehicleByPlateUseCase = deactivateVehicleByPlateUseCase;
        this.editVehicleUseCase = editVehicleUseCase;
    }

    @PostMapping("")
    public ResponseEntity<Vehicle> create(@RequestBody CreateVehicleRequest request) {
        Vehicle vehicleDomain = request.toDomain();
        Vehicle savedVehicle = registerVehicleUseCase.execute(vehicleDomain);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVehicle);
    }

    @PatchMapping("/{plate}")
    public ResponseEntity<Vehicle> update(@PathVariable String plate, @RequestBody CreateVehicleRequest request) {
        Vehicle vehicleDomain = request.toDomainForUpdate();
        Vehicle savedVehicle = editVehicleUseCase.execute(plate, vehicleDomain);
        return ResponseEntity.status(HttpStatus.OK).body(savedVehicle);
    }

    @GetMapping("")
    public ResponseEntity<List<Vehicle>> findAll() {
        List<Vehicle> vehicles = listAllVehiclesUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(vehicles);
    }

    @GetMapping("/{plate}")
    public ResponseEntity<Vehicle> findByPlate(@PathVariable String plate) {
        return findVehicleByPlateUseCase.execute(plate)
                .map(vehicle -> ResponseEntity.status(HttpStatus.OK).body(vehicle))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{plate}")
    public ResponseEntity<Void> DeactivateVehicle(@PathVariable String plate) {
        deactivateVehicleByPlateUseCase.execute(plate);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}