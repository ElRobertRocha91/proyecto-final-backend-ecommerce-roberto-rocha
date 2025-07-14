package com.TechLab.spring.controller;

import com.TechLab.spring.model.Producto;
import com.TechLab.spring.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/list")
    public List<Producto> listarProductos() {
        return productoService.listarTodos();
    }

    @GetMapping("/buscar")
    public List<Producto> listarPorNombre(@RequestParam String nombre) {
        return productoService.buscarPorNombre(nombre);
    }

    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable Long id) {
        return productoService.obtenerPorId(id);
    }

    @PostMapping("/")
    public Producto crearProducto (@RequestBody Producto nuevoProducto) {
        return productoService.guardar(nuevoProducto);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto (@PathVariable Long id, @RequestBody Producto datos) {
        return productoService.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        return productoService.eliminar(id);
    }
}
