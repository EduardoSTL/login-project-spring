package com.eduardo.loginprojectspring.models.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pais {
    private Integer id;
    private String codigo;
    private String nombre;

}
