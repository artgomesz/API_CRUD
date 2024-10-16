package com.library.libraryManagement.controller;


import com.library.libraryManagement.Service.LivrosService;
import com.library.libraryManagement.Service.UsuarioService;
import com.library.libraryManagement.model.livros.Livros;
import com.library.libraryManagement.model.livros.LivrosDto;
import com.library.libraryManagement.model.usuarios.Usuarios;
import com.library.libraryManagement.model.usuarios.UsuariosDto;
import com.library.libraryManagement.repository.LivroRepository;
import com.library.libraryManagement.repository.UsuarioRepository;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/biblioteca")
public class BibliotecaControler {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping("/livros")
    public Livros criarLivros(@RequestBody LivrosDto dadosL){
        Livros novoLivro = new Livros();
        novoLivro.setAno_publicacao(dadosL.ano_publicacao());
        novoLivro.setAutor(dadosL.autor());
        novoLivro.setCategoria(dadosL.categoria());
        novoLivro.setDisponivel(dadosL.disponivel());
        novoLivro.setISBN(dadosL.ISBN());
        novoLivro.setPreco(dadosL.preco());
        novoLivro.setTitulo(dadosL.titulo());

        return livroRepository.save(novoLivro);
    }

    @PostMapping("/usuarios")
    public Usuarios criaUsuarios(@RequestBody UsuariosDto dadosU ){
        Usuarios novoUsuario = new Usuarios();
        novoUsuario.setNome(dadosU.nome());
        novoUsuario.setEndereco(dadosU.endereco());;
        novoUsuario.setEmail(dadosU.email());
        novoUsuario.setCpf(dadosU.cpf());
        novoUsuario.setCep(dadosU.cep());
        
        return usuarioRepository.save(novoUsuario);

    }

    @GetMapping("/livros")
    public List<Livros> listarLivros(){
        return livroRepository.findAll();


    }

    @GetMapping("/usuarios")
    public List<Usuarios> listarUsuarios(){
        return usuarioRepository.findAll();
    }


    @Autowired
    private LivrosService livrosService;

    @PutMapping("/titulo/{titulo}")
    public ResponseEntity<Livros> AtualizarLivro(@PathVariable String titulo, @RequestBody Livros LivroAtualizado){
        Optional<Livros> livro = livrosService.LivroPorNome(titulo, LivroAtualizado);

        if (livro.isPresent()){
            return ResponseEntity.ok(livro.get());
        }
        else
            return ResponseEntity.notFound().build();
    }

    private UsuarioService usuarioService;

    @PutMapping("/nome/{nome}")
    public ResponseEntity<Usuarios> AtulizarUsuario(@PathVariable String nome, @RequestBody Usuarios usarioAtualizado){
        Optional<Usuarios> usuario = usuarioService.usuariosPorNome(nome, usarioAtualizado);

        if (usuario.isPresent()){
            return ResponseEntity.ok(usuario.get());
        }
        else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/titulo/{titulo}")
    public ResponseEntity<Void> excluirLivro(@PathVariable String titulo){
        Boolean deletado = livrosService.deletarPorTitulo(titulo);

        if (deletado){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/nome/{nome}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable String nome){
        Boolean deletado = usuarioService.DeletarUsuario(nome);
        if (deletado){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
