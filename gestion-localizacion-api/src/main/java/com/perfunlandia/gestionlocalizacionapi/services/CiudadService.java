package com.perfunlandia.gestionlocalizacionapi.services;

import org.springframework.stereotype.Service;
import com.perfunlandia.gestionlocalizacionapi.models.entities.Ciudad;
import com.perfunlandia.gestionlocalizacionapi.models.entities.Region;
import com.perfunlandia.gestionlocalizacionapi.repositories.CiudadRepository;
import com.perfunlandia.gestionlocalizacionapi.repositories.RegionRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CiudadService
{
    private final RegionRepository regionRepository;
    private final CiudadRepository ciudadRepository;

    public List<Ciudad> listarTodasLasCiudades()
    {
        return ciudadRepository.findAll();
    }
    
    public List<Ciudad> listarCiudadesPorRegion(String nombreRegion) {
        Region region = regionRepository.findByNombreRegion(nombreRegion)
                .orElseThrow(() -> new RuntimeException("Región no encontrada"));
        
        return ciudadRepository.findByRegion(region);
    }
}
