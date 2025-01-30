package com.example.webapp.service;

import com.example.webapp.model.HealthCheck;
import com.example.webapp.repository.HealthCheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckService {
    @Autowired
    private HealthCheckRepository healthCheckRepository;

    public boolean performHealthCheck() {
        try {
            healthCheckRepository.save(new HealthCheck());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
