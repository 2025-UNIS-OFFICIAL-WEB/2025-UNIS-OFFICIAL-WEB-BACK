package com.unis.api.controller;

import com.unis.api.dto.GetApplyInfoResponse;
import com.unis.api.service.ApplyService;
import com.unis.common.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apply")
@RequiredArgsConstructor
public class ApplyController {
    private final ApplyService applyService;
    @GetMapping("/info")
    public ResponseEntity<ApiResponse<?>> getApplyInfo() {
        GetApplyInfoResponse response = applyService.getApplyInfo();
        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
