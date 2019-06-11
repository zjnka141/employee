package com.employee.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = UniqueCodeValidator.class)
@Retention(RUNTIME)
@Target({ FIELD })
public @interface UniqueCode {
    String message() default "* Mã nhân viên này đã tồn tại trong database";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default{};
}
