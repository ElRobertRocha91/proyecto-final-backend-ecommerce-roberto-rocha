package com.TechLab.spring.dto;

import com.TechLab.spring.model.LineaPedido;

import java.util.List;

public class PedidoDTO {
    private Long usuarioId;
    private List<LineaPedidoDTO> lineapedido;

    public PedidoDTO() {
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<LineaPedidoDTO> getLineapedido() {
        return lineapedido;
    }

    public void setLineapedido(List<LineaPedidoDTO> lineapedido) {
        this.lineapedido = lineapedido;
    }
}
