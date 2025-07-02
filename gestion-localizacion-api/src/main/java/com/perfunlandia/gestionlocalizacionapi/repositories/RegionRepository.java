package com.perfunlandia.gestionlocalizacionapi.repositories;

import com.perfunlandia.gestionlocalizacionapi.models.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

// Esta importacion es para nombrar de mejor manera el retorno de un producto que no existe!
import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Integer>
{

    Optional<Region> findByNombreRegion(String nombreRegion);  // Buscamos una región por su nombre

}