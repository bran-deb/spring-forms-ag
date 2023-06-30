package com.spring.form.app.validators.emailValidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MailValidator implements ConstraintValidator<Mail, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value.matches(
                "/^(([^<>()\\[\\]\\\\.,;:\\s@\u201D]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\u201D]+)*)|(\u201C.+\u201D))@((\\[[0\u20139]{1,3}\\.[0\u20139]{1,3}\\.[0\u20139]{1,3}\\.[0\u20139]{1,3}])|(([a-zA-Z\\-0\u20139]+\\.)+[a-zA-Z]{2,}))$/")) {
            return false;
        }
        return true;
    }
}
