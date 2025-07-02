package com.perfunlandia.gestionlocalizacionapi.controller;

import com.perfunlandia.gestionlocalizacionapi.dto.DireccionDTO;
import com.perfunlandia.gestionlocalizacionapi.services.DireccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/direcciones")
@RequiredArgsConstructor
public class DireccionController
{

    private final DireccionService direccionService;

    // Endpoint para listar todas las direcciones (opcional)
    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<DireccionDTO>>> listarTodas() {
        // HATEOAS: Convertir cada dirección en un EntityModel con enlaces hipermedia
        List<EntityModel<DireccionDTO>> direcciones = direccionService.listarDireccionesDto()
                .stream()
                .map(direccion -> {
                    EntityModel<DireccionDTO> entityModel = EntityModel.of(direccion);
                    // Agregar enlace al API Gateway
                    entityModel.add(Link.of("http://localhost:8888/api-gateway/direcciones", "api-gateway"));
                    return entityModel;
                })
                .collect(Collectors.toList());

        CollectionModel<EntityModel<DireccionDTO>> collectionModel = CollectionModel.of(direcciones);
        collectionModel.add(Link.of("http://localhost:8888/api-gateway/direcciones", "api-gateway"));

        return ResponseEntity.ok(collectionModel);
    }

    // Endpoint para agregar una nueva dirección
    @PostMapping
    public ResponseEntity<EntityModel<DireccionDTO>> agregarDireccion(@RequestBody DireccionDTO dto) {
        DireccionDTO nuevaDireccion = direccionService.agregarDireccion(
                dto.getNombreCalle(),
                dto.getNumeracion(),
                dto.getNombreComuna(),
                dto.getNombreCiudad(),
                dto.getNombreRegion()
        );

        // HATEOAS: Crear EntityModel con enlaces hipermedia para la nueva dirección
        EntityModel<DireccionDTO> entityModel = EntityModel.of(nuevaDireccion);
        // Agregar enlace al API Gateway
        entityModel.add(Link.of("http://localhost:8888/api-gateway/direcciones", "api-gateway"));

        return ResponseEntity.ok(entityModel);
    }

    @GetMapping("/sucursales/{id}/existe")
    public ResponseEntity<Boolean> existeSucursal(@PathVariable Integer id) {
        boolean existe = direccionService.existeDireccion(id);
        return ResponseEntity.ok(existe);
    }
}