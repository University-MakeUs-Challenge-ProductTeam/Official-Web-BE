package umc.product.web.global.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.product.web.global.validation.annotation.CheckCursorValidation;

import static umc.product.web.global.error.code.status.ErrorStatus.NOT_VALID_CURSOR;

@Component
@RequiredArgsConstructor
public class CheckCursorValidator implements ConstraintValidator<CheckCursorValidation, Long> {
    @Override
    public void initialize(CheckCursorValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value <= 0) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(NOT_VALID_CURSOR.getMessage())
                    .addConstraintViolation();

            return false;
        }
        return true;
    }
}
