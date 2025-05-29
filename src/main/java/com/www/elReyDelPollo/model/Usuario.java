package com.www.elReyDelPollo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short idUsuario;

    @Column(nullable = false, length = 20, unique = true)
    private String nombreUsuario;

    @Column(nullable = false, length = 100)
    private String passwordUsuario;

    @Basic(optional = false)
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Basic(optional = true)
    @Column(nullable = true)
    private LocalDateTime updatedAt;

    @Basic(optional = true)
    @Column(nullable = true)
    private LocalDateTime deletedAt;

    public Usuario(String nombreUsuario, String passwordUsuario) {
        super();
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario = passwordUsuario;
        this.createdAt = LocalDateTime.now();
    }

}