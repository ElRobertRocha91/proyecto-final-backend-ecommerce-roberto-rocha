package com.TechLab.spring.controller;

import com.TechLab.spring.dto.PedidoDTO;
import com.TechLab.spring.model.Pedido;
import com.TechLab.spring.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/crear")
    public Pedido generarPedido(@RequestBody PedidoDTO dto) {
        Pedido pedido = pedidoService.crearPedido(dto);
        return pedido;
    }

    @GetMapping("/listar")
    public List<Pedido> listarPedidos() {
        return pedidoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Pedido obtenerPedido(@PathVariable Long id) {
        return pedidoService.obtenerPedidoPorId(id);
    }
}
