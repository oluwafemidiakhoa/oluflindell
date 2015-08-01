package lottery.backend.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;

import org.springframework.context.annotation.Configuration;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "lottery.backend.persistence")
@EnableAutoConfiguration
@EntityScan(basePackages = {"lottery.backend.domain"})
public class PersistenceConfig { }
