package com.example.hellokubernetes.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthCheck implements HealthIndicator {

    @Autowired
    private HealthService healthService;

    @Override
    public Health health() {
        int currentStatus = healthService.getStatus();
        if (currentStatus != 0) {
            return Health.down().withDetail("Error Code", currentStatus).build();
        }

        return Health.up().build();
    }

}
