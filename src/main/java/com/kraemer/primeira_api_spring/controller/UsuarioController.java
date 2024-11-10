package com.kraemer.primeira_api_spring.controller;

import com.kraemer.primeira_api_spring.model.Usuario;
import com.kraemer.primeira_api_spring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService service;


    @GetMapping
    public List<Usuario> getUsers() {
        return service.getUsers();
    }

    @GetMapping("/{id}")
    public Usuario getUser(@PathVariable Integer id) {
        return service.getUser(id);
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return service.createUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUsuario(@PathVariable("id") Integer id) {
        service.deleteUsuario(id);
    }

    @PutMapping("/{id}")
    public Usuario updateUsuario(@RequestBody Usuario usuario, @PathVariable("id") Integer id) {
        return service.updateUsuario(usuario, id);
    }
}
