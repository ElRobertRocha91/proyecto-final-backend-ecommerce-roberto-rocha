package com.TechLab.spring.repository;

import com.TechLab.spring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> { }
