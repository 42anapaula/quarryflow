package com.ana.quarryflow.core.domain.ports.in.material;

import java.util.List;

import com.ana.quarryflow.core.domain.model.Material;

public interface ListAllMaterialsUseCase {

    List<Material> execute();

}
