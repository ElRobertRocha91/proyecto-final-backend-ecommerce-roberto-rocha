package com.TechLab.spring.dto;

public class LineaPedidoDTO {
    private Long producto_Id;
    private int cantidad;

    public LineaPedidoDTO() {
    }

    public Long getProducto_Id() {
        return producto_Id;
    }

    public void setProducto_Id(Long producto_Id) {
        this.producto_Id = producto_Id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
