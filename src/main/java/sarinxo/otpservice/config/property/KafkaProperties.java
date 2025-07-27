package sarinxo.otpservice.config.property;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "otp-service.kafka")
@ConditionalOnProperty(
        prefix = "otp-service.kafka.send-otp", value = "enabled",
        havingValue = "true", matchIfMissing = true
)
public record KafkaProperties(
        @NotNull(message = "Property 'in-topic' can't be null")
        String inTopic,
        @NotNull(message = "Property 'out-topic' can't be null")
        String outTopic
) {

}
