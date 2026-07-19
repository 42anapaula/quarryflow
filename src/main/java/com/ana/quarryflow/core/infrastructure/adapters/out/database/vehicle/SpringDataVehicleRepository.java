package com.ana.quarryflow.core.infrastructure.adapters.out.database.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataVehicleRepository extends JpaRepository<VehicleEntity, String> {


}
