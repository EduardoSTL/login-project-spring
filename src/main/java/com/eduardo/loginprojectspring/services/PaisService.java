package com.eduardo.loginprojectspring.services;

import com.eduardo.loginprojectspring.models.domain.Pais;

import java.util.List;

public interface PaisService {
    List<Pais> listar();
    Pais obtenerPorId(Integer id);
}
