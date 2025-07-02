package com.perfunlandia.gestionlocalizacionapi.services;

import com.perfunlandia.gestionlocalizacionapi.models.entities.Region;
import com.perfunlandia.gestionlocalizacionapi.repositories.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionService {
    private final RegionRepository regionRepository;

    public List<Region> listarTodasLasRegiones() {
        return regionRepository.findAll();
    }
}