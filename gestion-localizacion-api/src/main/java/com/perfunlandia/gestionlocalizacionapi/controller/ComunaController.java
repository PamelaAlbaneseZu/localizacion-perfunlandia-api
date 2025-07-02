package com.perfunlandia.gestionlocalizacionapi.controller;

import com.perfunlandia.gestionlocalizacionapi.models.entities.Comuna;
import com.perfunlandia.gestionlocalizacionapi.services.ComunaService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/comunas")
@RequiredArgsConstructor
public class ComunaController
{

    private final ComunaService comunaService;

    @GetMapping("/por-ciudad")
    public ResponseEntity<CollectionModel<EntityModel<Comuna>>> listarPorCiudad(@RequestParam String nombreCiudad) {
        // HATEOAS: Convertir cada comuna en un EntityModel con enlaces hipermedia
        List<EntityModel<Comuna>> comunas = comunaService.listarComunasPorCiudad(nombreCiudad)
                .stream()
                .map(comuna -> {
                    EntityModel<Comuna> entityModel = EntityModel.of(comuna);
                    // Agregar enlace al API Gateway
                    entityModel.add(Link.of("http://localhost:8888/api-gateway/comunas", "api-gateway"));
                    return entityModel;
                })
                .collect(Collectors.toList());

        CollectionModel<EntityModel<Comuna>> collectionModel = CollectionModel.of(comunas);
        collectionModel.add(Link.of("http://localhost:8888/api-gateway/comunas", "api-gateway"));

        return ResponseEntity.ok(collectionModel);
    }

}

