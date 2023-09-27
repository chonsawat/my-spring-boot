package com.example.demo.common;

import com.example.utils.Coach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Fast bowling for 15 minutes";
    }
}
