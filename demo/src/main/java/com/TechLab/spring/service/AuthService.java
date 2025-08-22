package com.TechLab.spring.service;

import com.TechLab.spring.model.Role;
import com.TechLab.spring.model.Usuario;
import com.TechLab.spring.repository.RoleRepository;
import com.TechLab.spring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario registerUser(String username, String rawPassword) {
        Role userRole = roleRepository.findByNombre("ROLE_USER")
                .orElseGet(() -> roleRepository.save(new Role(null, "ROLE_USER")));

        Usuario usuario = new Usuario();
        usuario.setName(username);
        usuario.setPassword(passwordEncoder.encode(rawPassword));
        usuario.setRoles(List.of(userRole));

        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> authenticate(String username, String password) {
        Optional<Usuario> userOpt = usuarioRepository.findByUsername(username);
        if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPassword())) {
            return userOpt;
        }
        return Optional.empty();
    }
}
