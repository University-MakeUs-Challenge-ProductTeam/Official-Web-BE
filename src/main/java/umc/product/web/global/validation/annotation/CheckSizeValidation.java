package umc.product.web.global.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.product.web.global.validation.validator.CheckSizeValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckSizeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckSizeValidation {
    String message() default "size 값이 유효하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}