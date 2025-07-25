package sarinxo.otpservice.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class UuidStringValidator implements ConstraintValidator<UuidString, String> {

    public static final String UUID_PATTERN = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return value.matches(UUID_PATTERN);
    }

    public boolean isValid(String value) {
        if (value == null) {
            return true;
        }

        return value.matches(UUID_PATTERN);
    }

}
