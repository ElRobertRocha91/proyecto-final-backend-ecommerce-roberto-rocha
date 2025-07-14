package com.TechLab.spring.service;

import com.TechLab.spring.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.TechLab.spring.model.Producto;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repo;

    @Autowired
    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> listarTodos() {
        return repo.findAll();
    }

    public List<Producto> buscarPorNombre(String nombre) {
        return repo.findByNombre(nombre);
    }

    public Producto obtenerPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Producto guardar(Producto p) {
        return repo.save(p);
    }

    public Producto actualizar (Long id, Producto datos) {
        Producto p = obtenerPorId(id);
        if (p != null) {
            p.setNombre(datos.getNombre());
            p.setPrecio(datos.getPrecio());
            p.setStock(datos.getStock());
            p.setDescripcion(datos.getDescripcion());
            return repo.save(p);
        }
        return null;
    }

    public String eliminar(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Producto eliminado correctamente";
        }
        return "Producto no encontrado";
    }

}
