package sarinxo.otpservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sarinxo.otpservice.validation.UuidString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckRequest {
    /**
     * Идентификатор процесса в рамках которого запрашивается одноразовый пароль
     */
    @UuidString(message = "Incorrect 'processId' format")
    private String processId;
    /**
     * Одноразовый код
     */
    private String otp;
}
