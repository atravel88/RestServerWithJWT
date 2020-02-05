package ru.atavrel.restserverdemo.dao;

import org.springframework.data.repository.CrudRepository;
import ru.atavrel.restserverdemo.model.Role;

public interface RolesRepository extends CrudRepository<Role, Long> {

}

