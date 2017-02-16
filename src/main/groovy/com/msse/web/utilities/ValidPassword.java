package com.msse.web.utilities;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by z001hk8 on 2/12/17.
 */

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ValidPasswordValidator.class)
@interface ValidPassword {

    String message() default "{javax.validation.constraints.ValidPassword.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };


}
