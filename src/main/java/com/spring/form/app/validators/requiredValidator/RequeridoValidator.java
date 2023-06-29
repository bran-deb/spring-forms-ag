package com.spring.form.app.validators.requiredValidator;

// import org.springframework.util.StringUtils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequeridoValidator implements ConstraintValidator<Requerido, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        // if (value == null||!StringUtils.hasText(value)) {
        if (value.isEmpty() || value.isBlank() || value == null) {
            return false;
        }

        return true;
    }

}
