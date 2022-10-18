package com.mantra.backendside;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BackendSideApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendSideApplication.class, args);
    }

}
