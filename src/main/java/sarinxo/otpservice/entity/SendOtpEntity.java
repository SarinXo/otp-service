package sarinxo.otpservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import sarinxo.otpservice.entity.base.AuditableEntity;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "send_otp", schema = "otp")
public class SendOtpEntity extends AuditableEntity {

    @Id
    @UuidGenerator
    private UUID id;
    /**
     * Идентификатор процесса в рамках которого запрашивается одноразовый пароль
     */
    @Column(name = "process_id")
    private String processId;
    /**
     * Идентификатор телеграм чата
     */
    @Column(name = "telegram_chat_id")
    private String telegramChatId;
    /**
     * Текст сообщения
     */
    private String message;
    /**
     * Длина одноразового пароля
     */
    private Integer length;
    /**
     * Время жизни одноразового пароля
     */
    private Integer ttl;
    /**
     * Количество возможных повторных отправок кода
     */
    @Column(name = "resend_attempts")
    private Integer resendAttempts;
    /**
     * Таймаут перед повторным запросом кода, в секундах
     */
    @Column(name = "resend_timeout")
    private Integer resendTimeout;
    /**
     * Соль одноразового пароля
     */
    private String salt;
    /**
     * Идентификатор сообщения, отправляемого во внешнюю систему
     */
    @Column(name = "send_message_key")
    private String sendMessageKey;
    /**
     * Статус отправки сообщения
     */
    @Enumerated(EnumType.STRING)
    private MessageStatus status;
    /**
     * Время отправки одноразового пароля
     */
    @Column(name = "send_time")
    private OffsetDateTime sendTime;

    /**
     * Статус отправки сообщения
     */
    public enum MessageStatus {
        IN_PROCESS, DELIVERED, ERROR
    }

}
