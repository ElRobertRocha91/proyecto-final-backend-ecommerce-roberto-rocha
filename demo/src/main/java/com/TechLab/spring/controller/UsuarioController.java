package com.TechLab.spring.controller;

import com.TechLab.spring.model.Usuario;
import com.TechLab.spring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listaUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario obtenerUsuario(@PathVariable Long id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    @PostMapping("/")
    public Usuario crearUsuario(@RequestBody Usuario nuevoUsuario) {
        return usuarioService.guardarUsuario(nuevoUsuario);
    }

    @DeleteMapping("/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        return usuarioService.eliminar(id);
    }
}
