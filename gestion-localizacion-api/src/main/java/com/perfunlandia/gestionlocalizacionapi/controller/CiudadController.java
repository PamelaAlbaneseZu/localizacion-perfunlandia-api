package com.perfunlandia.gestionlocalizacionapi.controller;

import com.perfunlandia.gestionlocalizacionapi.models.entities.Ciudad;
import com.perfunlandia.gestionlocalizacionapi.services.CiudadService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ciudades")  //Ruta para Listar todas las ciudades
@RequiredArgsConstructor
public class CiudadController {

    private final CiudadService ciudadService;

    @GetMapping("/por-region")
    public ResponseEntity<CollectionModel<EntityModel<Ciudad>>> listarCiudadesPorRegion(@RequestParam String nombreRegion) {
        // HATEOAS: Convertir cada ciudad en un EntityModel con enlaces hipermedia
        List<EntityModel<Ciudad>> ciudades = ciudadService.listarCiudadesPorRegion(nombreRegion)
                .stream()
                .map(ciudad -> {
                    EntityModel<Ciudad> entityModel = EntityModel.of(ciudad);
                    // Agregar enlace al API Gateway
                    entityModel.add(Link.of("http://localhost:8888/api-gateway/ciudades", "api-gateway"));
                    return entityModel;
                })
                .collect(Collectors.toList());

        CollectionModel<EntityModel<Ciudad>> collectionModel = CollectionModel.of(ciudades);
        collectionModel.add(Link.of("http://localhost:8888/api-gateway/ciudades", "api-gateway"));

        return ResponseEntity.ok(collectionModel);
    }
}

