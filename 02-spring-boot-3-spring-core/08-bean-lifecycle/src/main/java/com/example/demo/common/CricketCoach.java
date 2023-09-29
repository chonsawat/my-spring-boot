package com.example.demo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Fast bowling for 15 minutes";
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("This " + getClass().getSimpleName() + " is doing after bean created");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("This " + getClass().getSimpleName() + " is doing before bean destroy");
    }
}
