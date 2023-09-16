package com.eduardo.loginprojectspring.services;

import com.eduardo.loginprojectspring.models.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoleService {
    List<Role> listar();
    Role obtenerPorId(Integer id);
}
