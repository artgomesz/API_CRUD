package com.library.libraryManagement.model.livros;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public record LivrosDto(
    
    @NotBlank
    String titulo, 

    int ISBN,

    String autor,

    int ano_publicacao,

    int preco,

    @Enumerated(EnumType.STRING)
    Categoria categoria,
    
    Boolean disponivel) {

}
