package com.spring.form.app.validators.requiredValidator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = RequeridoValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface Requerido {

    String message() default "El campo es requerido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
