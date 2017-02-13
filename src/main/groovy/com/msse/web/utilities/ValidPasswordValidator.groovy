package com.msse.web.utilities

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

/**
 * Created by z001hk8 on 2/12/17.
 */

class ValidPasswordValidator implements ConstraintValidator<ValidPassword, String> {


    @Override
    void initialize(ValidPassword constraintAnnotation) {

    }

    @Override
    boolean isValid(String value, ConstraintValidatorContext context) {

        if(!value || (value ==~ "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}\$")) {
            return true
        }
        return false

    }
}
