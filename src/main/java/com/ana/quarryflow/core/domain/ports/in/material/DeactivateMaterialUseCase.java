package com.ana.quarryflow.core.domain.ports.in.material;

import java.util.UUID;

public interface DeactivateMaterialUseCase {

    void execute(UUID id);
}
