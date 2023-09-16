package com.eduardo.loginprojectspring.services;

import com.eduardo.loginprojectspring.models.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> listar();
    Role obtenerPorId(Integer id);
}
