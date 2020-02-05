package ru.atavrel.restserverdemo.service;

import ru.atavrel.restserverdemo.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAll();
}