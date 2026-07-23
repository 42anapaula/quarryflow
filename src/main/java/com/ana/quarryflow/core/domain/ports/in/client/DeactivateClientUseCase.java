package com.ana.quarryflow.core.domain.ports.in.client;

import java.util.UUID;

public interface DeactivateClientUseCase {

    void execute(UUID id);
}
