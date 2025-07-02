package com.perfunlandia.gestionlocalizacionapi.repositories;


import com.perfunlandia.gestionlocalizacionapi.models.entities.Comuna;
import com.perfunlandia.gestionlocalizacionapi.models.entities.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Integer>
{

    List<Direccion> findByComuna(Comuna comuna);

}