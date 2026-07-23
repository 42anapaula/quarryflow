package com.ana.quarryflow.core.domain.ports.in.web.contract;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ana.quarryflow.core.domain.model.Client;
import com.ana.quarryflow.core.domain.model.Contract;
import com.ana.quarryflow.core.domain.ports.in.contract.DeactivateContractUseCase;
import com.ana.quarryflow.core.domain.ports.in.contract.EditContractUseCase;
import com.ana.quarryflow.core.domain.ports.in.contract.FindContractByIdUseCase;
import com.ana.quarryflow.core.domain.ports.in.contract.ListAllContractsUseCase;
import com.ana.quarryflow.core.domain.ports.in.contract.RegisterContractUseCase;
import com.ana.quarryflow.core.domain.ports.in.web.contract.dto.CreateContractRequest;
import com.ana.quarryflow.core.domain.ports.out.ClientRepository;

@RestController
@RequestMapping("/api/v1/contract")
public class ContractController {

    private final RegisterContractUseCase registerContractUseCase;
    private final ListAllContractsUseCase listAllContractsUseCase;
    private final FindContractByIdUseCase findContractByIdUseCase;
    private final EditContractUseCase editContractUseCase;
    private final DeactivateContractUseCase deactivateContractUseCase;
    private final ClientRepository clientRepository;

    public ContractController(RegisterContractUseCase registerContractUseCase,
            ListAllContractsUseCase listAllContractsUseCase,
            FindContractByIdUseCase findContractByIdUseCase,
            EditContractUseCase editContractUseCase,
            DeactivateContractUseCase deactivateContractUseCase,
            ClientRepository clientRepository) {
        this.registerContractUseCase = registerContractUseCase;
        this.listAllContractsUseCase = listAllContractsUseCase;
        this.findContractByIdUseCase = findContractByIdUseCase;
        this.editContractUseCase = editContractUseCase;
        this.deactivateContractUseCase = deactivateContractUseCase;
        this.clientRepository = clientRepository;
    }

    @PostMapping("")
    public ResponseEntity<Contract> create(@RequestBody CreateContractRequest request) {
        Client client = clientRepository.findById(UUID.fromString(request.clientId()))
            .orElseThrow(() -> new IllegalArgumentException("Client not found: " + request.clientId()));
        Contract contract = request.toDomain(client);
        Contract savedContract = registerContractUseCase.execute(contract);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContract);
    }

    @GetMapping("")
    public ResponseEntity<List<Contract>> findAll() {
        List<Contract> contracts = listAllContractsUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(contracts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> findById(@PathVariable UUID id) {
        return findContractByIdUseCase.execute(id)
                .map(contract -> ResponseEntity.status(HttpStatus.OK).body(contract))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Contract> update(@PathVariable UUID id, @RequestBody CreateContractRequest request) {
        Contract contractDomain = new Contract();
        contractDomain.setCreditLimit(request.creditLimit());
        contractDomain.setAvailableBalance(request.availableBalance());
        contractDomain.setActive(request.active() != null ? request.active() : true);
        contractDomain.setStartDate(request.startDate());
        contractDomain.setEndDate(request.endDate());
        Contract updatedContract = editContractUseCase.execute(id, contractDomain);
        return ResponseEntity.status(HttpStatus.OK).body(updatedContract);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivate(@PathVariable UUID id) {
        deactivateContractUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
