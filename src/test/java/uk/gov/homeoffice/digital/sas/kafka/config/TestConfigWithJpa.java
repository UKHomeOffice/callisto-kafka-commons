package uk.gov.homeoffice.digital.sas.kafka.config;

import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Import(TestConfig.class)
@EnableJpaRepositories("uk.gov.homeoffice.digital.sas.kafka.repository")
public class TestConfigWithJpa {
}
