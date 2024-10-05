package umc.product.web.global.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.product.web.global.validation.validator.CheckCursorValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckCursorValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckCursorValidation {
    String message() default "커서 값이 유효하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}