package com.TechLab.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "productos")
public class Producto {
    // @Id && @GeneratedValue ==> Indicamos que la propiedad id se autoincremente en nuestra tabla productos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private double precio;
    private String categoria;
    private String imagen;
    private int stock;

}
