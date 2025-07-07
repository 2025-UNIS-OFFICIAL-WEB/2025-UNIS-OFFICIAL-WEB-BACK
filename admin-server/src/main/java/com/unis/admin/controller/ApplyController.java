package com.unis.admin.controller;

import com.unis.admin.dto.PutApplyInfoRequest;
import com.unis.admin.service.ApplyService;
import com.unis.common.global.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/apply")
public class ApplyController {
    private final ApplyService applyService;

    @PutMapping("/")
    public ResponseEntity<ApiResponse<?>> putApplyInfo(@RequestBody @Valid PutApplyInfoRequest request) {
        applyService.putApplyInfo(request);
        return ResponseEntity.ok(ApiResponse.success(null));
    }
}
