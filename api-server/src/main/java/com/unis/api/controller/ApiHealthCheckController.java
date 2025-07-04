package com.unis.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiHealthCheckController {

    @GetMapping("/health")
    public String checkHealth() {
        return "API 서버 굴러간다~...";
    }
}
