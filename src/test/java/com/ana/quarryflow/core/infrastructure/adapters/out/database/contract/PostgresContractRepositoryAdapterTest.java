package com.ana.quarryflow.core.infrastructure.adapters.out.database.contract;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import com.ana.quarryflow.core.domain.model.Client;
import com.ana.quarryflow.core.domain.model.Contract;
import com.ana.quarryflow.core.infrastructure.adapters.out.database.client.ClientEntity;
import com.ana.quarryflow.core.infrastructure.adapters.out.database.client.SpringDataClientRepository;

class PostgresContractRepositoryAdapterTest {

    @Test
    void shouldPersistClientRelationWhenSavingContract() {
        SpringDataContractRepository contractRepository = mock(SpringDataContractRepository.class);
        SpringDataClientRepository clientRepository = mock(SpringDataClientRepository.class);
        PostgresContractRepositoryAdapter adapter = new PostgresContractRepositoryAdapter(contractRepository, clientRepository);

        Client client = new Client("12345678901", "Acme Ltd", LocalDateTime.now());
        client.setId(UUID.randomUUID());
        Contract contract = new Contract(client, BigDecimal.TEN, BigDecimal.ONE, LocalDateTime.now(), LocalDateTime.now().plusDays(30));
        contract.setId(UUID.randomUUID());

        ClientEntity savedClientEntity = ClientEntity.fromDomain(client);
        savedClientEntity.setId(client.getId());
        when(clientRepository.save(any(ClientEntity.class))).thenReturn(savedClientEntity);

        ContractEntity savedContractEntity = new ContractEntity();
        savedContractEntity.setId(contract.getId());
        savedContractEntity.setClient(savedClientEntity);
        when(contractRepository.save(any(ContractEntity.class))).thenReturn(savedContractEntity);

        adapter.save(contract);

        verify(clientRepository).save(any(ClientEntity.class));

        ArgumentCaptor<ContractEntity> contractEntityCaptor = ArgumentCaptor.forClass(ContractEntity.class);
        verify(contractRepository).save(contractEntityCaptor.capture());

        ContractEntity persistedContract = contractEntityCaptor.getValue();
        assertNotNull(persistedContract.getClient());
        assertEquals(client.getId(), persistedContract.getClient().getId());
    }
}
