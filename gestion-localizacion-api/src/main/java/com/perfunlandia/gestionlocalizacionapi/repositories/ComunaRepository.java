package com.perfunlandia.gestionlocalizacionapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.perfunlandia.gestionlocalizacionapi.models.entities.Comuna;
import com.perfunlandia.gestionlocalizacionapi.models.entities.Ciudad;

import java.util.Optional;
import java.util.List;
public interface ComunaRepository extends JpaRepository<Comuna, Integer>
{

    Optional<Comuna> findByNombreComuna(String nombreComuna);     //Permite llamar a un objeto de comuna por el nombre y no por id
    List<Comuna> findByCiudad(Ciudad ciudad);         //Aqui extrae las comunas pertenecientes a x ciudad
    
}