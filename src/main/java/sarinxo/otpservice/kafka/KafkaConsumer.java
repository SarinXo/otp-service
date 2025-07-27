package sarinxo.otpservice.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import sarinxo.otpservice.config.property.KafkaProperties;
import sarinxo.otpservice.dto.kafka.KafkaInDto;
import sarinxo.otpservice.dto.kafka.KafkaOutDto;

@Slf4j
@Component
@RequiredArgsConstructor
@ConditionalOnProperty(
        prefix = "otp-service.kafka.send-otp", value = "enabled",
        havingValue = "true", matchIfMissing = true
)
public class KafkaConsumer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaProperties kafkaProperties;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "${otp-service.kafka.out-topic}")
    public void consume(KafkaOutDto dto) {
        log.info("Consume message in outTopic: {}", dto);
        //пока без логики
    }

    public void send(KafkaInDto dto) {
        log.info("Start to send message in inTopic");
        try {
            String payload = objectMapper.writeValueAsString(dto);
            kafkaTemplate.send(kafkaProperties.inTopic(), payload);
            log.info("Successful send message in {} with body: {}", kafkaProperties.inTopic(), dto);
        } catch (JsonProcessingException e) {
            log.error("Fail to send message: {} cause: {}", dto, e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
