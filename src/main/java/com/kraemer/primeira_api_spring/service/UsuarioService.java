package com.kraemer.primeira_api_spring.service;

import com.kraemer.primeira_api_spring.handler.BusinessException;
import com.kraemer.primeira_api_spring.model.Usuario;
import com.kraemer.primeira_api_spring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> getUsers() {
        return repository.findAll();
    }

    public Usuario getUser(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    public Usuario createUsuario(Usuario usuario) {
        if(usuario.getLogin() == null)
            throw new BusinessException("Campo login é obrigatório");
        return repository.save(usuario);
    }

    public void deleteUsuario( Integer id) {
        repository.deleteById(id);
    }

    public Usuario updateUsuario(Usuario usuario, Integer id) {
        var atualizar = repository.findById(id).get();
        if(atualizar != null) {
            usuario.setId(id);
            return repository.save(usuario);
        }
        return null;
    }
}
