package com.perfunlandia.gestionlocalizacionapi.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
// tambien podria importarse un persistence.*; para no tener que
// declarar tantos import

@Entity
@Getter
@Setter
@Table(name = "comuna")
public class Comuna extends RepresentationModel<Comuna>
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comuna")
    private Integer id;

    @Column(name = "nombre_comuna")
    private String nombreComuna;

    @ManyToOne
    @JoinColumn(name = "id_ciudad")
    private Ciudad ciudad; // Cada comuna está asociada a una ciudad
    //                        O muchas comunas pertenecen a una ciudad

}