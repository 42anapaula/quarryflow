package com.ana.quarryflow.core.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ana.quarryflow.core.application.usecases.vehicle.DeactivateVehicleByPlateService;
import com.ana.quarryflow.core.application.usecases.vehicle.EditVehicleService;
import com.ana.quarryflow.core.application.usecases.vehicle.FindVehicleByPlateService;
import com.ana.quarryflow.core.application.usecases.vehicle.ListAllVehiclesService;
import com.ana.quarryflow.core.application.usecases.vehicle.RegisterVehicleService;
import com.ana.quarryflow.core.domain.ports.in.vehicle.DeactivateVehicleByPlateUseCase;
import com.ana.quarryflow.core.domain.ports.in.vehicle.EditVehicleUseCase;
import com.ana.quarryflow.core.domain.ports.in.vehicle.FindVehicleByPlateUseCase;
import com.ana.quarryflow.core.domain.ports.in.vehicle.ListAllVehiclesUseCase;
import com.ana.quarryflow.core.domain.ports.in.vehicle.RegisterVehicleUseCase;
import com.ana.quarryflow.core.domain.ports.out.VehicleRepository;
import com.ana.quarryflow.core.infrastructure.adapters.out.database.vehicle.PostgresVehicleRepositoryAdapter;
import com.ana.quarryflow.core.infrastructure.adapters.out.database.vehicle.SpringDataVehicleRepository;

@Configuration
public class BeanConfiguration {
    
    @Bean
    public VehicleRepository vehicleRepository(SpringDataVehicleRepository springDataVehicleRepository) {
        return new PostgresVehicleRepositoryAdapter(springDataVehicleRepository);
    }

    @Bean
    public RegisterVehicleUseCase registerVehicleUseCase(VehicleRepository vehicleRepository) {
        return new RegisterVehicleService(vehicleRepository);
    }

    @Bean
    public ListAllVehiclesUseCase listAllVehiclesUseCase(VehicleRepository vehicleRepository) {
        return new ListAllVehiclesService(vehicleRepository);
    }

    @Bean
    public FindVehicleByPlateUseCase findVehicleByPlateUseCase(VehicleRepository vehicleRepository) {
        return new FindVehicleByPlateService(vehicleRepository);
    }

    @Bean
    public EditVehicleUseCase editVehicleUseCase(VehicleRepository vehicleRepository) {
        return new EditVehicleService(vehicleRepository);
    }

    @Bean
    public DeactivateVehicleByPlateUseCase deactivateVehicleByPlateUseCase(VehicleRepository vehicleRepository) {
        return new DeactivateVehicleByPlateService(vehicleRepository);
    }
}
