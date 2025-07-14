package com.TechLab.spring.repository;

import com.TechLab.spring.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

// Capa de consultas a la base de datos
public interface PedidoRepository extends JpaRepository<Pedido, Long> {}
