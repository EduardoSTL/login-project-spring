package com.eduardo.loginprojectspring.models.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pais {
    //pais no tiene validacion ya que en el formulario
    //el usuario no lo digita, solo lo selecciona
    private Integer id;
    private String codigo;
    private String nombre;

}
