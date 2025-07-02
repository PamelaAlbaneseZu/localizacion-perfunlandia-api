package com.perfunlandia.gestionlocalizacionapi.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "direccion")
public class Direccion extends RepresentationModel<Direccion>
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Integer idDireccion;

    @Column(name = "nombre_calle")
    private String nombreCalle;

    @Column(name = "numeracion")
    private String numeracion;

    @Column(name = "depto")
    private String depto;

    @ManyToOne
    @JoinColumn(name = "id_comuna")
    private Comuna comuna;
    
}
