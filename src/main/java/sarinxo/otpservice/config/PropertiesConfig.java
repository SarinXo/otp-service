package sarinxo.otpservice.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationPropertiesScan(basePackages = "sarinxo.otpservice.config.property")
public class PropertiesConfig {

}
