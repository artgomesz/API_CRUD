package com.library.libraryManagement.model.usuarios;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString

@Entity(name = "Usuário")
@Table(name = "Usuários")

public class Usuarios {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int cpf;
    private int cep;
    private String endereco;
    private String email;
}
