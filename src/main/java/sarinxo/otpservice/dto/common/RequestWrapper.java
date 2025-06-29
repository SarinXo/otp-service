package sarinxo.otpservice.dto.common;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record RequestWrapper<T>(
        @Valid
        @NotNull(message = "Field 'body' can't be null")
        T body
) {

    public static <T> RequestWrapper<T> of(T body) {
        return new RequestWrapper<>(body);
    }

}
