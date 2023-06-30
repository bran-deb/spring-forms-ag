package com.spring.form.app.validators.emailValidator;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = MailValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface Mail {
    String message() default "No tiene el formato de un email";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
