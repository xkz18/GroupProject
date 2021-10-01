package com.example.demo.Service.impl;

import com.example.demo.Repository.*;
import com.example.demo.ResourceManager.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Service.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll(){
        return repository.findAll();
    }

    @Override
    public User save(User user){
        return repository.save(user);
    }

    @Override
    public User create(User user){
        user.setDateCreated(new Date(System.currentTimeMillis()));
        return repository.save(user);
    }
}