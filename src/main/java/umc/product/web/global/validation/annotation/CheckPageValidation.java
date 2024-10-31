package umc.product.web.global.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.product.web.global.validation.validator.CheckPageValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckPageValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPageValidation {
    String message() default "page 값이 유효하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
