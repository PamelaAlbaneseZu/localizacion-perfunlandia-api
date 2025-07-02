package com.perfunlandia.gestionlocalizacionapi.services;

import org.springframework.stereotype.Service;

import com.perfunlandia.gestionlocalizacionapi.models.entities.Ciudad;
import com.perfunlandia.gestionlocalizacionapi.models.entities.Comuna;
import com.perfunlandia.gestionlocalizacionapi.repositories.ComunaRepository;
import com.perfunlandia.gestionlocalizacionapi.repositories.CiudadRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ComunaService {

     private final ComunaRepository comunaRepository;
    private final CiudadRepository ciudadRepository;

    public List<Comuna> listarComunasPorCiudad(String nombreCiudad) {
        Ciudad ciudad = ciudadRepository.findByNombreCiudad(nombreCiudad)
                .orElseThrow(() -> new RuntimeException("Ciudad no encontrada"));
        return comunaRepository.findByCiudad(ciudad);
    }
}