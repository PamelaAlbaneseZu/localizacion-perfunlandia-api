package com.perfunlandia.gestionlocalizacionapi.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class DireccionDTO extends RepresentationModel<DireccionDTO>
{
    private String nombreCalle;
    private String numeracion;
    private String nombreComuna;
    private String nombreCiudad;
    private String nombreRegion;

}