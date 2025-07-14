package com.TechLab.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

// ItemsPedido
@Entity
public class LineaPedido {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Producto producto;

    private int cantidad;

    // Constructor
    public LineaPedido() {
    }

    // Getter & Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}

