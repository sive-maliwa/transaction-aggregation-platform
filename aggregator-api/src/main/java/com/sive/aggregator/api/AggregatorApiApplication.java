package com.sive.aggregator.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.sive")
@EnableJpaRepositories(basePackages = "com.sive.persistence.repo")
@EntityScan(basePackages = "com.sive.persistence.entity")
public class AggregatorApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AggregatorApiApplication.class, args);
    }
}
