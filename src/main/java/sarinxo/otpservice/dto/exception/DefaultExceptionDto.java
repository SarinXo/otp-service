package sarinxo.otpservice.dto.exception;

import java.time.LocalDateTime;

public record DefaultExceptionDto(
        LocalDateTime timestamp,
        String exceptionMessage
) {

}
