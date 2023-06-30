package com.spring.form.app.controllers;

import java.net.PasswordAuthentication;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.spring.form.app.editors.NombreMayusEditor;
import com.spring.form.app.editors.NombreMinusEditor;
import com.spring.form.app.models.domain.User;
import com.spring.form.app.validators.UserValidator;

import jakarta.validation.Valid;

// se pasa el nombre nombre del objeto que se pasa a la vista
@SessionAttributes("usuario") // para que se mantenga el usuario en sesion durante la vida de la aplicacion"
@Controller
public class FormController {

    @Autowired
    private UserValidator validator;

    @InitBinder // registra el validador
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(validator); // agrega el validador
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false); // no permite fechas con formato incorrecto(estricto)
        binder.registerCustomEditor(
                Date.class,
                "fechaNacimiento", // nombre del atributo para que no aplique en todos los date
                new CustomDateEditor(dateFormat, true));// registra un filtro para date
        binder.registerCustomEditor(
                String.class,
                "nombre", // atributo al que aplica
                new NombreMayusEditor()); // registra un filtro personalizado
        binder.registerCustomEditor(
                String.class,
                "apellido",
                new NombreMayusEditor());
        binder.registerCustomEditor(
                String.class,
                "username",
                new NombreMinusEditor());
        binder.registerCustomEditor(
                String.class,
                "password",
                new NombreMinusEditor());
    }

    @GetMapping("/form")
    public String form(
            @ModelAttribute("user") User usuario,
            Model model) {
        usuario.setNombre("John");
        usuario.setApellido("Doe");
        usuario.setId("123.456.789-K");
        model.addAttribute("titulo", "Formulario de usuario");
        model.addAttribute("user", usuario);
        return "form";
    }

    @PostMapping("/form")
    public String formPost(
            @Valid @ModelAttribute("user") User usuario, // auto mapeo si sus atributos tienen mismo nombre
            BindingResult result, // valida formularios
            Model model,
            SessionStatus status // para cerrar sesion
    // @RequestParam(name = "username") String nombre,
    // @RequestParam(name = "password") String contraseña,
    // @RequestParam(name = "email") String mail
    ) {
        // User user = new User();
        // user.setUsername(nombre);
        // user.setPassword(contraseña);
        // user.setEmail(mail);
        model.addAttribute("titulo", "Resultado form");

        // validator.validate(usuario, result);
        if (result.hasErrors()) {
            // Map<String, String> errores = new HashMap<>();
            // result.getFieldErrors().forEach(err -> {
            // errores.put(err.getField(),
            // "El campo "
            // .concat(err.getField())
            // .concat(" ")
            // .concat(err.getDefaultMessage()));
            // });

            // model.addAttribute("error", errores);
            return "form";
        }

        model.addAttribute("user", usuario);
        status.setComplete(); // para cerrar sesion
        return "resultado";
    }
}
