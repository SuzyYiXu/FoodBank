package com.primaryfeed.controller;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class HealthController {
    @GetMapping("/") public Map<String,String> root() {
        return Map.of("app","PrimaryFeed","status","running","phase","3");
    }
    @GetMapping("/health") public Map<String,String> health() {
        return Map.of("status","OK");
    }
}