package com.example.ATS.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RutValidationConstraint implements
        ConstraintValidator<ValidRut, String> {

    @Override
    public boolean isValid(String rut, ConstraintValidatorContext context) {
        return Rut.isValid(rut);
    }

}