package com.sparta.sailitem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SailItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SailItemApplication.class, args);
    }

}
