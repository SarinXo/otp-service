package sarinxo.otpservice.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import sarinxo.otpservice.config.property.KafkaProperties;

@Configuration
@EnableKafka
@RequiredArgsConstructor
@ConditionalOnProperty(
        prefix = "otp-service.kafka.send-otp", value = "enabled",
        havingValue = "true", matchIfMissing = true
)
public class KafkaConfig {

    private final KafkaProperties kafkaProperties;

    @Bean
    public NewTopic otpChangePhoneInV1Topic() {
        return TopicBuilder
                .name(kafkaProperties.inTopic())
                .partitions(3)
                .compact()
                .build();
    }

    @Bean
    public NewTopic otpChangePhoneOutV1Topic() {
        return TopicBuilder
                .name(kafkaProperties.outTopic())
                .partitions(3)
                .compact()
                .build();
    }

}
