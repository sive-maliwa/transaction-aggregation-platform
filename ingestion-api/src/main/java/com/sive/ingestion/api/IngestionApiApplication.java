package com.sive.ingestion.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.sive")
@EnableJpaRepositories(basePackages = "com.sive.persistence.repo")
@EntityScan(basePackages = "com.sive.persistence.entity")
public class IngestionApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(IngestionApiApplication.class, args);
    }
}
