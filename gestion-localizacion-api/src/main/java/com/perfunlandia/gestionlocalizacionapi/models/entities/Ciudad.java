package com.perfunlandia.gestionlocalizacionapi.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;


@Entity
@Getter
@Setter
public class Ciudad extends RepresentationModel<Ciudad> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_ciudad")
    private Integer id;

    @Column(name = "nombre_ciudad")
    private String nombreCiudad;

    @ManyToOne
    @JoinColumn(name = "id_region")
    private Region region; // Muchas ciudad pueden estar asociadas asociada a una región

}