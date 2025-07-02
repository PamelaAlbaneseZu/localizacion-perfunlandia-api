package com.perfunlandia.gestionlocalizacionapi.controller;

import com.perfunlandia.gestionlocalizacionapi.models.entities.Region;
import com.perfunlandia.gestionlocalizacionapi.services.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/regiones")
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<Region>>> listarTodas() {
        // HATEOAS: Convertir cada región en un EntityModel con enlaces hipermedia
        List<EntityModel<Region>> regiones = regionService.listarTodasLasRegiones()
                .stream()
                .map(region -> {
                    EntityModel<Region> entityModel = EntityModel.of(region);
                    // Agregar enlace al API Gateway
                    entityModel.add(Link.of("http://localhost:8888/api-gateway/regiones", "api-gateway"));
                    return entityModel;
                })
                .collect(Collectors.toList());

        CollectionModel<EntityModel<Region>> collectionModel = CollectionModel.of(regiones);
        collectionModel.add(Link.of("http://localhost:8888/api-gateway/regiones", "api-gateway"));

        return ResponseEntity.ok(collectionModel);
    }
}

