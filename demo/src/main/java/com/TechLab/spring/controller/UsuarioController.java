package com.TechLab.spring.controller;

import com.TechLab.spring.model.Usuario;
import com.TechLab.spring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Usuario>> listaUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.obtenerUsuarioPorId(id));
    }

    @PostMapping("/")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario nuevoUsuario) {
        return ResponseEntity.ok(usuarioService.guardarUsuario(nuevoUsuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.eliminar(id));
    }
}
