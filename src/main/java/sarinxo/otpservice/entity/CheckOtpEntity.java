package sarinxo.otpservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

import static sarinxo.otpservice.entity.CheckOtpEntity.TABLE_NAME;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TABLE_NAME)
public class CheckOtpEntity extends AuditableEntity {

    public final static String TABLE_NAME = "check_otp";

    @Id
    @UuidGenerator
    private UUID id;
    /**
     * Идентификатор процесса в рамках которого запрашивается одноразовый пароль
     */
    @Column(name = "process_id")
    private String processId;
    /**
     * Введенный клиентом код
     */
    @Column(name = "otp")
    private String otp;
    /**
     * Время проверки
     */
    @Column(name = "check_time")
    private OffsetDateTime checkTime;
    /**
     * Признак корректности введенного пароля
     */
    private Boolean correct;

}
