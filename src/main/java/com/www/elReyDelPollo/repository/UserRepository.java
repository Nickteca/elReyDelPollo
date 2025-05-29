package com.www.elReyDelPollo.repository;

import com.www.elReyDelPollo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario, Short> {
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}
