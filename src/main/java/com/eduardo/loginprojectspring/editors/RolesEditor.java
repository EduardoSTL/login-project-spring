package com.eduardo.loginprojectspring.editors;

import com.eduardo.loginprojectspring.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class RolesEditor extends PropertyEditorSupport {
    //@Qualifier("")
    @Autowired
    private RoleService service;

    //valida el texto:
    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        try {
            //enviamos el id como texto y lo convertimos a int para que lo reciba la interfaz de RoleService
            Integer id = Integer.parseInt(text);
            setValue(service.obtenerPorId(id));
        } catch (NumberFormatException e){
            setValue(null);
        }
    }
}