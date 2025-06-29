package sarinxo.otpservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @UuidString(message = "Incorrect 'processId' UUID format")
    @NotNull(message = "Field 'processId' can't be null")
    private String processId;
    /**
     * Канал отправки сообщения
     */
    @NotNull(message = "Field 'sendingChannel' can't be null")
    private SendingChanel sendingChannel;
    /**
     * Идентификатор телеграмм чата.
     * Зависит от поля 'sendingChannel'.
     * Если канал выбран как консоль, то значение игнорируется.
     */
    @NotBlank(message = "Field 'target' can't be blank")
    private String target;
    /**
     * Текст сообщения (с плейсхолдером '%s')
     */
    @NotBlank(message = "Field 'message' can't be blank")
    private String message;
    /**
     * Длина одноразового пароля
     */
    @NotNull(message = "Field 'length' can't be null")
    @Range(min = 4, max = 8, message = "The 'length' of the password is resent should range from 4 to 8")
    private Integer length;
    /**
     * Время жизни одноразового пароля в секундах
     */
    @NotNull(message = "Field 'ttl' can't be null")
    @Min(value = 30, message = "The lifetime of a temporary 'ttl' password cannot be less than 30 seconds")
    private Integer ttl;
    /**
     * Кол-во повторных отправок
     */
    @NotNull(message = "Field 'resendAttempts' can't be null")
    @Range(min = 1, max = 3, message = "The number of times the message 'resendAttempts' is resent should range from 1 to 3")
    private Integer resendAttempts;
    /**
     * Таймаут перед повторным запросом кода в секундах
     */
    @NotNull(message = "Field 'resendTimeout' can't be null")
    @Min(value = 30, message = "The resend timeout 'resendTimeout' of a temporary password cannot be less than 30 seconds")
    private Integer resendTimeout;

}
