package sarinxo.otpservice.dto.exception;

import java.time.LocalDateTime;
import java.util.UUID;

public record DefaultExceptionDto(
        UUID id,
        LocalDateTime timestamp,
        String exceptionMessage
) {

}
