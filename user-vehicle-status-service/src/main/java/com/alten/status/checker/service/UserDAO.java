package com.alten.status.checker.service;

import com.alten.status.checker.model.entity.User;
import com.alten.status.checker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAO {
    @Autowired
    private UserRepository repository;

    public void save(User user) {
        repository.save(user);
    }

    public UserRepository getRepository() {
        return repository;
    }

    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }
}
