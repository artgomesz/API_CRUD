package com.library.libraryManagement.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.libraryManagement.model.livros.Livros;

@Repository
public interface LivroRepository extends JpaRepository<Livros,Long>{

    Optional<Livros>findLivrosByTitulo(String titulo);
}
