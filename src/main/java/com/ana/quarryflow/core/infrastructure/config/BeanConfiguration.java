package com.ana.quarryflow.core.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ana.quarryflow.core.application.usecases.client.DeactivateClientService;
import com.ana.quarryflow.core.application.usecases.client.EditClientService;
import com.ana.quarryflow.core.application.usecases.client.FindClientByIdService;
import com.ana.quarryflow.core.application.usecases.client.ListAllClientsService;
import com.ana.quarryflow.core.application.usecases.client.RegisterClientService;
import com.ana.quarryflow.core.application.usecases.contract.DeactivateContractService;
import com.ana.quarryflow.core.application.usecases.contract.EditContractService;
import com.ana.quarryflow.core.application.usecases.contract.FindContractByIdService;
import com.ana.quarryflow.core.application.usecases.contract.ListAllContractsService;
import com.ana.quarryflow.core.application.usecases.contract.RegisterContractService;
import com.ana.quarryflow.core.application.usecases.material.DeactivateMaterialService;
import com.ana.quarryflow.core.application.usecases.material.EditMaterialService;
import com.ana.quarryflow.core.application.usecases.material.FindMaterialByIdService;
import com.ana.quarryflow.core.application.usecases.material.ListAllMaterialsService;
import com.ana.quarryflow.core.application.usecases.material.RegisterMaterialService;
import com.ana.quarryflow.core.application.usecases.vehicle.DeactivateVehicleByPlateService;
import com.ana.quarryflow.core.application.usecases.vehicle.EditVehicleService;
import com.ana.quarryflow.core.application.usecases.vehicle.FindVehicleByPlateService;
import com.ana.quarryflow.core.application.usecases.vehicle.ListAllVehiclesService;
import com.ana.quarryflow.core.application.usecases.vehicle.RegisterVehicleService;
import com.ana.quarryflow.core.domain.ports.in.client.DeactivateClientUseCase;
import com.ana.quarryflow.core.domain.ports.in.client.EditClientUseCase;
import com.ana.quarryflow.core.domain.ports.in.client.FindClientByIdUseCase;
import com.ana.quarryflow.core.domain.ports.in.client.ListAllClientsUseCase;
import com.ana.quarryflow.core.domain.ports.in.client.RegisterClientUseCase;
import com.ana.quarryflow.core.domain.ports.in.contract.DeactivateContractUseCase;
import com.ana.quarryflow.core.domain.ports.in.contract.EditContractUseCase;
import com.ana.quarryflow.core.domain.ports.in.contract.FindContractByIdUseCase;
import com.ana.quarryflow.core.domain.ports.in.contract.ListAllContractsUseCase;
import com.ana.quarryflow.core.domain.ports.in.contract.RegisterContractUseCase;
import com.ana.quarryflow.core.domain.ports.in.material.DeactivateMaterialUseCase;
import com.ana.quarryflow.core.domain.ports.in.material.EditMaterialUseCase;
import com.ana.quarryflow.core.domain.ports.in.material.FindMaterialByIdUseCase;
import com.ana.quarryflow.core.domain.ports.in.material.ListAllMaterialsUseCase;
import com.ana.quarryflow.core.domain.ports.in.material.RegisterMaterialUseCase;
import com.ana.quarryflow.core.domain.ports.in.vehicle.DeactivateVehicleByPlateUseCase;
import com.ana.quarryflow.core.domain.ports.in.vehicle.EditVehicleUseCase;
import com.ana.quarryflow.core.domain.ports.in.vehicle.FindVehicleByPlateUseCase;
import com.ana.quarryflow.core.domain.ports.in.vehicle.ListAllVehiclesUseCase;
import com.ana.quarryflow.core.domain.ports.in.vehicle.RegisterVehicleUseCase;
import com.ana.quarryflow.core.domain.ports.out.ClientRepository;
import com.ana.quarryflow.core.domain.ports.out.ContractRepository;
import com.ana.quarryflow.core.domain.ports.out.MaterialRepository;
import com.ana.quarryflow.core.domain.ports.out.VehicleRepository;
import com.ana.quarryflow.core.infrastructure.adapters.out.database.client.PostgresClientRepositoryAdapter;
import com.ana.quarryflow.core.infrastructure.adapters.out.database.client.SpringDataClientRepository;
import com.ana.quarryflow.core.infrastructure.adapters.out.database.contract.PostgresContractRepositoryAdapter;
import com.ana.quarryflow.core.infrastructure.adapters.out.database.contract.SpringDataContractRepository;
import com.ana.quarryflow.core.infrastructure.adapters.out.database.material.PostgresMaterialRepositoryAdapter;
import com.ana.quarryflow.core.infrastructure.adapters.out.database.material.SpringDataMaterialRepository;
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

    @Bean
    public ClientRepository clientRepository(SpringDataClientRepository springDataClientRepository) {
        return new PostgresClientRepositoryAdapter(springDataClientRepository);
    }

    @Bean
    public RegisterClientUseCase registerClientUseCase(ClientRepository clientRepository) {
        return new RegisterClientService(clientRepository);
    }

    @Bean
    public ListAllClientsUseCase listAllClientsUseCase(ClientRepository clientRepository) {
        return new ListAllClientsService(clientRepository);
    }

    @Bean
    public FindClientByIdUseCase findClientByIdUseCase(ClientRepository clientRepository) {
        return new FindClientByIdService(clientRepository);
    }

    @Bean
    public EditClientUseCase editClientUseCase(ClientRepository clientRepository) {
        return new EditClientService(clientRepository);
    }

    @Bean
    public DeactivateClientUseCase deactivateClientUseCase(ClientRepository clientRepository) {
        return new DeactivateClientService(clientRepository);
    }

    @Bean
    public MaterialRepository materialRepository(SpringDataMaterialRepository springDataMaterialRepository) {
        return new PostgresMaterialRepositoryAdapter(springDataMaterialRepository);
    }

    @Bean
    public RegisterMaterialUseCase registerMaterialUseCase(MaterialRepository materialRepository) {
        return new RegisterMaterialService(materialRepository);
    }

    @Bean
    public ListAllMaterialsUseCase listAllMaterialsUseCase(MaterialRepository materialRepository) {
        return new ListAllMaterialsService(materialRepository);
    }

    @Bean
    public FindMaterialByIdUseCase findMaterialByIdUseCase(MaterialRepository materialRepository) {
        return new FindMaterialByIdService(materialRepository);
    }

    @Bean
    public EditMaterialUseCase editMaterialUseCase(MaterialRepository materialRepository) {
        return new EditMaterialService(materialRepository);
    }

    @Bean
    public DeactivateMaterialUseCase deactivateMaterialUseCase(MaterialRepository materialRepository) {
        return new DeactivateMaterialService(materialRepository);
    }

    @Bean
    public ContractRepository contractRepository(SpringDataContractRepository springDataContractRepository,
            SpringDataClientRepository springDataClientRepository) {
        return new PostgresContractRepositoryAdapter(springDataContractRepository, springDataClientRepository);
    }

    @Bean
    public RegisterContractUseCase registerContractUseCase(ContractRepository contractRepository) {
        return new RegisterContractService(contractRepository);
    }

    @Bean
    public ListAllContractsUseCase listAllContractsUseCase(ContractRepository contractRepository) {
        return new ListAllContractsService(contractRepository);
    }

    @Bean
    public FindContractByIdUseCase findContractByIdUseCase(ContractRepository contractRepository) {
        return new FindContractByIdService(contractRepository);
    }

    @Bean
    public EditContractUseCase editContractUseCase(ContractRepository contractRepository) {
        return new EditContractService(contractRepository);
    }

    @Bean
    public DeactivateContractUseCase deactivateContractUseCase(ContractRepository contractRepository) {
        return new DeactivateContractService(contractRepository);
    }
}
