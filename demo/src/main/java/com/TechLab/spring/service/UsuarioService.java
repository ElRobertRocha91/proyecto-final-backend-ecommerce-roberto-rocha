package com.TechLab.spring.service;

import com.TechLab.spring.model.Usuario;
import com.TechLab.spring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;

    @Autowired
    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public List<Usuario> listarUsuarios() {
        return repo.findAll();
    }

    public Usuario guardarUsuario(Usuario u) {
        return repo.save(u);
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public String eliminar(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Usuario elimindado correctamente";
        }
        return "Usuariio no encontrado";
    }

}
