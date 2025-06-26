package sarinxo.otpservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import sarinxo.otpservice.validation.UuidString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenerateRequest {
    /**
     * Идентификатор процесса в рамках которого запрашивается одноразовый пароль
     */
    @UuidString(message = "Incorrect 'processId' format")
    private String processId;
    /**
     * Идентификатор телеграмм чата
     */
    private String telegramChatId;
    /**
     * Текст сообщения (с плейсхолдером '%s')
     */
    @NotBlank(message = "Field 'message' can't be empty")
    private String message;
    /**
     * Длина одноразового пароля
     */
    @Range(min = 4, max = 8, message = "The 'length' of the password is resent should range from 4 to 8")
    private Integer length;
    /**
     * Время жизни одноразового пароля в секундах
     */
    @Min(value = 30, message = "The lifetime of a temporary 'ttl' password cannot be less than 30 seconds")
    private Integer ttl;
    /**
     * Кол-во повторных отправок
     */
    @Range(min = 1, max = 3, message = "The number of times the message 'resendAttempts' is resent should range from 1 to 3")
    private Integer resendAttempts;
    /**
     * Таймаут перед повторным запросом кода в секундах
     */
    @Min(value = 30, message = "The resend timeout 'resendTimeout' of a temporary password cannot be less than 30 seconds")
    private Integer resendTimeout;
}
