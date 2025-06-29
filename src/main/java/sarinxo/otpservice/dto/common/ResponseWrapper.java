package sarinxo.otpservice.dto.common;

import java.util.UUID;

public record ResponseWrapper<T>(
        UUID id,
        T body
) {

    public static <T> ResponseWrapper<T> of(T body) {
        return new ResponseWrapper<>(UUID.randomUUID(), body);
    }

}

