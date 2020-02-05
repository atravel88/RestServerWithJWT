package ru.atavrel.restserverdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.atavrel.restserverdemo.dao.RolesRepository;
import ru.atavrel.restserverdemo.model.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RolesRepository rolesRepository;

    @Autowired
    public void setRolesRepository(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public List<Role> getAll() {
        return (List<Role>) rolesRepository.findAll();
    }
}