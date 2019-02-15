package com.example.hellokubernetes.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthUpdateController {

    @Autowired
    private HealthService healthService;

    @GetMapping("/updateHealth")
    public void updateHealth(@RequestParam("status") final int status) {
        healthService.updateStatus(status);
    }
}
