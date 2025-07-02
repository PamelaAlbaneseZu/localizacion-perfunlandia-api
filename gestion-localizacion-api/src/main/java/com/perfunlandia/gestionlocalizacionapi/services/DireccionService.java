package com.perfunlandia.gestionlocalizacionapi.services;

import com.perfunlandia.gestionlocalizacionapi.dto.DireccionDTO;
import com.perfunlandia.gestionlocalizacionapi.models.entities.*;
import com.perfunlandia.gestionlocalizacionapi.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DireccionService
{

    private final DireccionRepository direccionRepository;
    private final ComunaRepository comunaRepository;
    private final CiudadRepository ciudadRepository;
    private final RegionRepository regionRepository;

    public DireccionDTO agregarDireccion(String nombreCalle,String numeracion, String nombreComuna, String nombreCiudad, String nombreRegion)
    
    {
        Region region = regionRepository.findByNombreRegion(nombreRegion)
                .orElseThrow(() -> new RuntimeException("Región no encontrada"));

        Ciudad ciudad = ciudadRepository.findByNombreCiudad(nombreCiudad)
                .orElseThrow(() -> new RuntimeException("Ciudad no encontrada"));

        Comuna comuna = comunaRepository.findByNombreComuna(nombreComuna)
                .orElseThrow(() -> new RuntimeException("Comuna no encontrada"));

        if (!ciudad.getRegion().getId().equals(region.getId()))
        {
            throw new RuntimeException("La ciudad no pertenece a la región indicada.");
        }

        if (!comuna.getCiudad().getId().equals(ciudad.getId()))
        {
            throw new RuntimeException("La comuna no pertenece a la ciudad indicada.");
        }

        Direccion direccion = new Direccion();
        direccion.setNombreCalle(nombreCalle);
        direccion.setNumeracion(numeracion);
        direccion.setComuna(comuna);

        Direccion guardada = direccionRepository.save(direccion);
        return convertirADto(guardada);
    }

    public List<DireccionDTO> listarDireccionesDto()
    {
        return direccionRepository.findAll()
                .stream()
                .map(this::convertirADto)
                .toList();
    }

    private DireccionDTO convertirADto(Direccion direccion)
    {
        DireccionDTO dto = new DireccionDTO();
        dto.setNombreCalle(direccion.getNombreCalle());
        direccion.setNumeracion(dto.getNumeracion());
        dto.setNombreComuna(direccion.getComuna().getNombreComuna());
        dto.setNombreCiudad(direccion.getComuna().getCiudad().getNombreCiudad());
        dto.setNombreRegion(direccion.getComuna().getCiudad().getRegion().getNombreRegion());
        return dto;
    }

    public boolean existeDireccion(Integer id) {
    return direccionRepository.existsById(id);
}
}