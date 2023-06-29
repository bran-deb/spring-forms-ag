package com.spring.form.app.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.form.app.models.domain.User;

@Component("UserValidator")
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    // customisando los mensajes de error de las anotaciones
    @Override
    public void validate(Object target, Errors errors) {
        // User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "NotEmpty.user.nombre");
        // Otra forma de validar nombre
        // if (user.getName().isEmpty()) {
        // errors.rejectValue("nombre", "NotEmpty.user.nombre");
        // }

        // validar id
        // if (!user.getId().matches("[0-9]{2}[.,-][\\d]{3}[.,-][\\d]{3}[-][A-Z]{1}")) {
        // errors.rejectValue("id", "pattern.user.id");
        // }
    }
}
