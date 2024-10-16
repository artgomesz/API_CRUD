package com.library.libraryManagement.Service;

import com.library.libraryManagement.model.usuarios.Usuarios;
import com.library.libraryManagement.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public Optional<Usuarios> usuariosPorNome(@PathVariable String nome, @RequestBody Usuarios UsuarioAtulizado){
        Optional<Usuarios> usuarioNome = usuarioRepository.findUsuariosByNome(nome);

        if(usuarioNome.isPresent()){

            Usuarios usuarios = usuarioNome.get();
            usuarios.setNome(UsuarioAtulizado.getNome());
            usuarios.setCpf(UsuarioAtulizado.getCpf());
            usuarios.setCep(UsuarioAtulizado.getCep());
            usuarios.setEndereco(UsuarioAtulizado.getEndereco());
            usuarios.setEmail(UsuarioAtulizado.getEmail());

            usuarioRepository.save(usuarios);
            return Optional.of(usuarios);
        }

        return Optional.empty();
    }

    public Boolean DeletarUsuario(@PathVariable String nome){
        Optional<Usuarios> usuario = usuarioRepository.findUsuariosByNome(nome);

        if (usuario.isPresent()){
            usuarioRepository.delete(usuario.get());
            return true;
        }
        return false;
    }

}