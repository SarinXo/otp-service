package sarinxo.otpservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @UuidString(message = "Incorrect 'processId' UUID format")
    @NotNull(message = "Field 'processId' can't be null")
    private String processId;
    /**
     * Одноразовый код
     */
    @NotBlank(message = "Field 'otp' can't be blank")
    private String otp;

}
