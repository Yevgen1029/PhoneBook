package com.yevgen.util.annotations;

import com.yevgen.util.Constants;
import com.yevgen.util.LoginConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LoginConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Login {
    String message() default Constants.LOGIN_CONSISTENCE_ERROR;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}