package com.spring.form.app.validators.emailValidator;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Target;

import jakarta.validation.Constraint;

@Constraint(validatedBy = EmailValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface Email {

}
