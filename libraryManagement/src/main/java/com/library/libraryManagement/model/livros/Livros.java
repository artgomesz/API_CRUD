package com.library.libraryManagement.model.livros;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity(name = "Livro")
@Table(name = "Livros")

public class Livros {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    private String titulo;
    private int ISBN;
    private String autor;
    private int  ano_publicacao;
    private int preco;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private Boolean disponivel;
}
