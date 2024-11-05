package umc.product.web.global.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.product.web.global.validation.annotation.CheckSizeValidation;

import static umc.product.web.global.error.code.status.ErrorStatus.NOT_VALID_SIZE;

@Component
@RequiredArgsConstructor
public class CheckSizeValidator implements ConstraintValidator<CheckSizeValidation, Integer> {
    @Override
    public void initialize(CheckSizeValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value <= 0) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(NOT_VALID_SIZE.getMessage())
                    .addConstraintViolation();

            return false;
        }
        return true;
    }
}
