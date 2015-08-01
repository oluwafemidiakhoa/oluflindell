package lottery.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lottery.backend.config.ApplicationConfig;

import lottery.backend.server.ServletContainerCustomizer;
import lottery.backend.server.SimpleCORSFilter;

@SpringBootApplication
public class LotteryApplication {
    public static void main(final String[] args) {
        SpringApplication.run(new Object[] {LotteryApplication.class, ApplicationConfig.class, ServletContainerCustomizer.class, SimpleCORSFilter.class}, args);
    }
}
