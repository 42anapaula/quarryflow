package com.ana.quarryflow.core.domain.ports.in.web.material;

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

import com.ana.quarryflow.core.domain.model.Material;
import com.ana.quarryflow.core.domain.ports.in.material.DeactivateMaterialUseCase;
import com.ana.quarryflow.core.domain.ports.in.material.EditMaterialUseCase;
import com.ana.quarryflow.core.domain.ports.in.material.FindMaterialByIdUseCase;
import com.ana.quarryflow.core.domain.ports.in.material.ListAllMaterialsUseCase;
import com.ana.quarryflow.core.domain.ports.in.material.RegisterMaterialUseCase;
import com.ana.quarryflow.core.domain.ports.in.web.material.dto.CreateMaterialRequest;

@RestController
@RequestMapping("/api/v1/material")
public class MaterialController {

    private final RegisterMaterialUseCase registerMaterialUseCase;
    private final ListAllMaterialsUseCase listAllMaterialsUseCase;
    private final FindMaterialByIdUseCase findMaterialByIdUseCase;
    private final EditMaterialUseCase editMaterialUseCase;
    private final DeactivateMaterialUseCase deactivateMaterialUseCase;

    public MaterialController(RegisterMaterialUseCase registerMaterialUseCase,
            ListAllMaterialsUseCase listAllMaterialsUseCase,
            FindMaterialByIdUseCase findMaterialByIdUseCase,
            EditMaterialUseCase editMaterialUseCase,
            DeactivateMaterialUseCase deactivateMaterialUseCase) {
        this.registerMaterialUseCase = registerMaterialUseCase;
        this.listAllMaterialsUseCase = listAllMaterialsUseCase;
        this.findMaterialByIdUseCase = findMaterialByIdUseCase;
        this.editMaterialUseCase = editMaterialUseCase;
        this.deactivateMaterialUseCase = deactivateMaterialUseCase;
    }

    @PostMapping("")
    public ResponseEntity<Material> create(@RequestBody CreateMaterialRequest request) {
        Material material = request.toDomain();
        Material savedMaterial = registerMaterialUseCase.execute(material);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMaterial);
    }

    @GetMapping("")
    public ResponseEntity<List<Material>> findAll() {
        List<Material> materials = listAllMaterialsUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(materials);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> findById(@PathVariable UUID id) {
        return findMaterialByIdUseCase.execute(id)
                .map(material -> ResponseEntity.status(HttpStatus.OK).body(material))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Material> update(@PathVariable UUID id, @RequestBody CreateMaterialRequest request) {
        Material materialDomain = request.toDomain();
        Material updatedMaterial = editMaterialUseCase.execute(id, materialDomain);
        return ResponseEntity.status(HttpStatus.OK).body(updatedMaterial);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivate(@PathVariable UUID id) {
        deactivateMaterialUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
