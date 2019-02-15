package com.example.hellokubernetes.health;

import org.springframework.stereotype.Service;

@Service
public class HealthService {

    private int status = 0;

    public int getStatus() {
        return status;
    }

    public void updateStatus(final int newStatus) {
        status = newStatus;
    }
}
