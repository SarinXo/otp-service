package sarinxo.otpservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckRequest {

    /**
     * Одноразовый код
     */
    @NotBlank(message = "Field 'otp' can't be blank")
    private String otp;

}
