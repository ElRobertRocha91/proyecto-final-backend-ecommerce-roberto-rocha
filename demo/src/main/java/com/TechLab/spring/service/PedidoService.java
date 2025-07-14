package com.TechLab.spring.service;

import com.TechLab.spring.dto.LineaPedidoDTO;
import com.TechLab.spring.dto.PedidoDTO;
import com.TechLab.spring.exception.StockInsuficienteException;
import com.TechLab.spring.model.LineaPedido;
import com.TechLab.spring.model.Pedido;
import com.TechLab.spring.model.Producto;
import com.TechLab.spring.repository.PedidoRepository;
import com.TechLab.spring.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Service para crear, leer, actualizar y eliminar de la tabla pedidos
@Service
public class PedidoService {

    private final PedidoRepository repo;

    @Autowired
    public PedidoService(PedidoRepository repo) {
        this.repo = repo;
    }

    @Autowired
    public ProductoRepository productoRepository;

    public Pedido crearPedido(PedidoDTO dto) {
        List<LineaPedido> lineasPedido = new ArrayList<>();

        // Recorremos la lista del carrito
        for (LineaPedidoDTO lineaDTO : dto.getLineapedido()) {
            // Obtengo la información del producto seleccionado por ID
            Producto producto = productoRepository.findById(lineaDTO.getProducto_Id())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + lineaDTO.getProducto_Id()));
            // Validamos si hay stock suficiente para hacer el pedido
            if (producto.getStock() < lineaDTO.getCantidad()) {
                throw new StockInsuficienteException("Stock insuficiente para el producto: " + producto.getNombre());
            }
            // Descontamos la cantidad solicitada del stock
            producto.setStock(producto.getStock() - lineaDTO.getCantidad());
            // Guardamos el producto
            productoRepository.save(producto);

            // Creamos LineaPedido con el producto real
            LineaPedido linea = new LineaPedido();
            linea.setProducto(producto);
            linea.setCantidad(lineaDTO.getCantidad());
            lineasPedido.add(linea);
        }

        // Establecemos las variables del objeto pedido y lo creamos
        Pedido pedido = new Pedido();
        pedido.setUsuarioId(dto.getUsuarioId());
        pedido.setLineaPedido(lineasPedido);
        pedido.setEstado("PENDIENTE");
        return repo.save(pedido);
    }

    public List<Pedido> listarTodos() {
        return repo.findAll();
    }

    public Pedido obtenerPedidoPorId(Long id) {
        return repo.findById(id).orElse(null);
    }
}
