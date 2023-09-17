package com.eduardo.loginprojectspring.models.domain;

import com.eduardo.loginprojectspring.validation.IdentificadorRegex;
import com.eduardo.loginprojectspring.validation.Requerido;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Usuario {
    //Establecer los formatos requeridos que se guardaran en la base de datos
    //no definimos un constructor ya que no mandamos los datos en un solo conjunto
    //es decir que la info se envia uno por uno
    @IdentificadorRegex
    private String identificador;
    private String nombre;

    @Requerido
    private String apellido;

    @NotBlank
    //no puede quedar vacio y minimo un caracter
    @Size(min = 2, max = 8)
    private String username;

    @NotEmpty
    private String password;

    @Requerido
    @Email(message = "correo con formato incorrecto")
    private String email;

    @NotNull
    @Min(5)
    @Max(5000)
    private Integer cuenta;

    @NotNull
    @Past
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;

    @NotNull
    private Pais pais;

    @NotEmpty
    private List<Role> roles;

    private boolean habilitar;

    @NotEmpty
    private String genero;
    private String valorSecreto;
}
