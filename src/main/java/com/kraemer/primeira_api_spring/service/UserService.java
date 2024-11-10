package com.kraemer.primeira_api_spring.service;

import com.kraemer.primeira_api_spring.handler.BusinessException;
import com.kraemer.primeira_api_spring.model.User;
import com.kraemer.primeira_api_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUser(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    public User createUser(User user) {
        if(user.getLogin() == null){
            throw new BusinessException("Campo login é obrigatório");
        }
        return repository.save(user);
    }

    public void deleteUser( Integer id) {
        repository.deleteById(id);
    }

    public User updateUser(User user, Integer id) {
        repository.findById(id).orElseThrow(
                () -> new BusinessException("Este usuário não existe")
        );
        user.setId(id);
        return repository.save(user);
    }
}
