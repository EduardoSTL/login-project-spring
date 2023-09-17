package com.eduardo.loginprojectspring.controllers;

import com.eduardo.loginprojectspring.editors.NombreMayusculaEditor;
import com.eduardo.loginprojectspring.editors.PaisPropertyEditor;
import com.eduardo.loginprojectspring.editors.RolesEditor;
import com.eduardo.loginprojectspring.models.domain.Pais;
import com.eduardo.loginprojectspring.models.domain.Role;
import com.eduardo.loginprojectspring.models.domain.Usuario;
import com.eduardo.loginprojectspring.services.PaisService;
import com.eduardo.loginprojectspring.services.RoleService;
import com.eduardo.loginprojectspring.validation.UsuarioValidador;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@SessionAttributes("usuario")
public class FormController {
    @Autowired
    private UsuarioValidador validador;
    @Autowired
    private PaisService paisService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PaisPropertyEditor paisEditor;
    @Autowired
    private RolesEditor roleEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(validador);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(dateFormat, true));

        binder.registerCustomEditor(String.class, "nombre", new NombreMayusculaEditor());
        binder.registerCustomEditor(String.class, "apellido", new NombreMayusculaEditor());

        binder.registerCustomEditor(Pais.class, "pais", paisEditor);
        binder.registerCustomEditor(Role.class, "roles", roleEditor);
    }

    @ModelAttribute("genero")
    public List<String> genero(){
        return Arrays.asList("Hombre", "Mujer");
    }

    @ModelAttribute("listaRoles")
    public List<Role> listaRoles(){
        return this.roleService.listar();
    }

    @ModelAttribute("listaPaises")
    public List<Pais> listaPaises(){
        return this.paisService.listar();
    }

    @ModelAttribute("listaRolesString")
    public List<String> listaRolesString(){
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        roles.add("ROLE_MODERATOR");
        return roles;
    }

    @ModelAttribute("listaRolesMap")
    public Map<String, String> listaRolesMap(){
        Map<String, String> roles = new HashMap<>();
        roles.put("ROLE_ADMIN", "Administrador");
        roles.put("ROLE_USER", "Usuario");
        roles.put("ROLE_MODERATOR", "Moderator");
        return roles;
    }

    @ModelAttribute("paises")
    public List<String> paises(){
        return Arrays.asList("España", "México", "Chile", "Argentina", "Perú", "Colombia", "Venezuela");
    }

    @ModelAttribute("paisesMap")
    public Map<String, String> paisesMap(){
        Map<String, String> paises = new HashMap<>();
        paises.put("ES", "España");
        paises.put("MX", "México");
        paises.put("CL", "Chile");
        paises.put("AR", "Argentina");
        paises.put("PE", "Perú");
        paises.put("CO", "Colombia");
        paises.put("VE", "Venezuela");
        return paises;
    }

    //ruta de la url con la que inicia la API rest
    @GetMapping("/form")
    public String form(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("John");
        usuario.setApellido("Doe");
        usuario.setIdentificador("123.456.789-K");
        usuario.setHabilitar(true);
        usuario.setValorSecreto("Algun valor secreto ****");
        usuario.setPais(new Pais(3, "CL", "Chile"));
        usuario.setRoles(Arrays.asList(new Role(3, "Usuario", "ROLE_USER")));

        model.addAttribute("titulo", "Formulario usuarios");
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @PostMapping("/forms")
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("titulo", "Resultado form");
            return "form";
        }
        return "redirect:/ver";
    }

    @GetMapping("/ver")
    public String ver(@SessionAttribute(name = "usuario", required = false)
                          Usuario usuario, Model model, SessionStatus status){
        if (usuario == null){
            return "redirect:/form";
        }
        model.addAttribute("titulo", "Resultado form");
        status.setComplete();
        return "resultado";
    }
}