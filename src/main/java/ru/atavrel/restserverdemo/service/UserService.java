package ru.atavrel.restserverdemo.service;

import ru.atavrel.restserverdemo.model.User;

import java.util.List;

public interface UserService {

    User getById(Long id);

    List<User> getAll();

    User getUserByEmail(String email);

    void add(User user);

    void deleteById(Long id);

}