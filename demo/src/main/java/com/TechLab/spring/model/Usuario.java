package com.TechLab.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String email;

    // Establecemos la relación que tendra con los roles de uno x uno.
    // Ej: solo puede tener un rol(usuario o administrador)
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

}
