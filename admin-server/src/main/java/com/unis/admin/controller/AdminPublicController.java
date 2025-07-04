package com.unis.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/public")
public class AdminPublicController {

    @GetMapping("/health")
    public String publicHealthCheck() {
        return "어드민 서버도 굴러간다!";
    }
}
