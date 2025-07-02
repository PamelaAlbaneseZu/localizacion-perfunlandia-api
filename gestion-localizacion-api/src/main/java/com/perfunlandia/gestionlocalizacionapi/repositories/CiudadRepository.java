package com.perfunlandia.gestionlocalizacionapi.repositories;

import com.perfunlandia.gestionlocalizacionapi.models.entities.Ciudad;
import com.perfunlandia.gestionlocalizacionapi.models.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

//Esta importacion es la estructura que almacena los datos extraidos
//o llamados por los metodos desde la base de datos
import java.util.List;
import java.util.Optional;


public interface CiudadRepository extends JpaRepository<Ciudad, Integer>
{

    Optional<Ciudad> findByNombreCiudad(String nombreCiudad);
    List<Ciudad> findByRegion(Region region);
    //Aqui esta diciendo que extraiga todas las ciudades asociadas a una region especifica
    
}