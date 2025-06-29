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
import org.hibernate.proxy.HibernateProxy;
import sarinxo.otpservice.entity.base.AuditableEntity;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "check_otp", schema = "otp")
public class CheckOtpEntity extends AuditableEntity {

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

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy
                ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass()
                : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass()
                : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        CheckOtpEntity that = (CheckOtpEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode()
                : getClass().hashCode();
    }

}
