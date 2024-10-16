package com.library.libraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.libraryManagement.model.usuarios.Usuarios;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios,Long> {

    Optional<Usuarios>findUsuariosByNome(String Nome);
}
