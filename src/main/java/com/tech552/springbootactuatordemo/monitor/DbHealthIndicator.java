package com.tech552.springbootactuatordemo.monitor;

import java.util.Random;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DbHealthIndicator implements HealthIndicator{

    @Override
    public Health health() {
        if(isDBHealthy()){
            return Health.up().withDetail("External DB Service", "Healthy").build();
        }
        return Health.down().withDetail("External DB Service", "Unhealthy").build();
    }

    //Mimics a call to DB 
    private boolean isDBHealthy(){
        
        Random random = new Random();
        return random.nextBoolean();
    }   
}