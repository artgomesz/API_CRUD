package com.library.libraryManagement.Service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.libraryManagement.model.livros.Livros;

import com.library.libraryManagement.repository.LivroRepository;




@Service
public class LivrosService {

    @Autowired
    private LivroRepository livroRepository;



    public Optional<Livros> LivroPorNome(String titulo, Livros LivroAtualizado){

         Optional<Livros>LivroPorNome = livroRepository.findLivrosByTitulo(titulo);

         if (LivroPorNome.isPresent()) {

             Livros livro = LivroPorNome.get();
             livro.setTitulo(LivroAtualizado.getTitulo());
             livro.setAutor(LivroAtualizado.getAutor());
             livro.setCategoria(LivroAtualizado.getCategoria());
             livro.setAno_publicacao(LivroAtualizado.getAno_publicacao());
             livro.setDisponivel(LivroAtualizado.getDisponivel());

             livroRepository.save(livro);

             return Optional.of(livro);
         }

         return Optional.empty();


    }

    public Boolean deletarPorTitulo(String titulo){
        Optional<Livros> livrosOptional = livroRepository.findLivrosByTitulo(titulo);
        if (livrosOptional.isPresent()) {
            livroRepository.delete(livrosOptional.get());
            return true;
        }
        return false;
    }

}
