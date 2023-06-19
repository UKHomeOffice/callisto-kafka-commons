package uk.gov.homeoffice.digital.sas.kafka.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("uk.gov.homeoffice.digital.sas.kafka")
@EntityScan("uk.gov.homeoffice.digital.sas.kafka.model")
public class TestConfig {
}
