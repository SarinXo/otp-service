package sarinxo.otpservice.dto.common;

import jakarta.validation.Valid;
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
public class RequestWrapper<T> {

    /**
     * Идентификатор процесса в рамках которого запрашивается одноразовый пароль
     */
    @UuidString(message = "Incorrect 'processId' UUID format")
    @NotNull(message = "Field 'processId' can't be null")
    private String processId;
    /**
     * Тело запроса
     */
    @Valid
    @NotNull(message = "Field 'body' can't be null")
    private T body;

}
