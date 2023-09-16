package com.eduardo.loginprojectspring.models.domain;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private Integer id;
    private String nombre;
    private String role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return this.id != null && this.id.equals(role.getId());
    }
}
