package com.yevgen.util.annotations;

import com.yevgen.util.Constants;
import com.yevgen.util.PhoneConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {
    String message() default Constants.PHONE_NUMBER_FORMAT_ERROR;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

