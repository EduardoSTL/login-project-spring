package com.eduardo.loginprojectspring.editors;


import com.eduardo.loginprojectspring.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class PaisPropertyEditor extends PropertyEditorSupport {
    //@Qualifier("")
    @Autowired
    private PaisService service;

    @Override
    public void setAsText(String idString) throws IllegalArgumentException{
        try {
            Integer id = Integer.parseInt(idString);
            setValue(service.obtenerPorId(id));
        } catch (NumberFormatException e){
            setValue(null);
        }
    }
}
