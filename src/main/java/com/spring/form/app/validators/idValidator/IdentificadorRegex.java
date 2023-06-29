package com.spring.form.app.validators.idValidator;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;

@Constraint(validatedBy = IdentificadorRegexValidator.class) // enlaza la class con la anotacion
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface IdentificadorRegex {

    String message() default "id invalido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
