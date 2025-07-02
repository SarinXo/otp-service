package sarinxo.otpservice.dto.common;

import java.util.UUID;

public record ResponseWrapper<T>(
        UUID id,
        T body
) {

    public static <T> ResponseWrapper<T> of(UUID id, T body) {
        return new ResponseWrapper<>(id, body);
    }

}

