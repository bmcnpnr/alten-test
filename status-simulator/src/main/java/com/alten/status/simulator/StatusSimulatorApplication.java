package com.alten.status.simulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StatusSimulatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(StatusSimulatorApplication.class, args);
    }

}
